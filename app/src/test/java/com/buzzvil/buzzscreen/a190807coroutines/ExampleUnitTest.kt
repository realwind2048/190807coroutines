package com.buzzvil.buzzscreen.a190807coroutines

import com.buzzvil.buzzscreen.a190807coroutines.uc03syncapi.coroutines.SyncCoroutinesUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun testSyncCoroutinesUseCase() = runBlocking {
        val result = SyncCoroutinesUseCase().excute()
        Truth.assertThat(result).isEqualTo(500500)
    }
}
