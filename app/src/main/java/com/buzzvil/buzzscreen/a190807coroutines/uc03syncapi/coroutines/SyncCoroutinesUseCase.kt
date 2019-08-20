package com.buzzvil.buzzscreen.a190807coroutines.uc03syncapi.coroutines

import com.buzzvil.buzzscreen.a190807coroutines.uc03syncapi.SyncDummyClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SyncCoroutinesUseCase {
    suspend fun excute(): Int {
        return withContext(Dispatchers.Main) {
            SyncDummyClass.veryDifficultBlockingCallWithResult()
        }
    }
}