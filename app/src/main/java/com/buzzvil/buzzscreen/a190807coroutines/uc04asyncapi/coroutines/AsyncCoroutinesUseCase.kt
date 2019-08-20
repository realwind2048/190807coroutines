package com.buzzvil.buzzscreen.a190807coroutines.uc04asyncapi.coroutines

import com.buzzvil.buzzscreen.a190807coroutines.uc04asyncapi.AsyncDummyCallback
import com.buzzvil.buzzscreen.a190807coroutines.uc04asyncapi.AsyncDummyClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class AsyncCoroutinesUseCase {
    suspend fun excute(): Int {
        return withContext(Dispatchers.Main) {
            AsyncCoroutineAPISuspend.veryDifficultResult()
        }
    }
}

object AsyncCoroutineAPISuspend {
    suspend fun veryDifficultResult(): Int {
        return suspendCoroutine { continuation ->
            AsyncDummyClass.veryDifficultResult(object: AsyncDummyCallback {
                override fun onSuccess(result: Int) {
                    continuation.resume(result)
                }

                override fun onFailure() {
                    continuation.resumeWithException(IllegalStateException())
                }
            })
        }
    }
}