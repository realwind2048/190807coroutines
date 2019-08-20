package com.buzzvil.buzzscreen.a190807coroutines.uc04syncapi.normal

import com.buzzvil.buzzscreen.a190807coroutines.uc04syncapi.SyncDummyClass

class SyncNormalUseCase {
    fun excute(callback: SyncDummyCallback) {
        Thread {
            val result = SyncDummyClass.veryDifficultBlockingCallWithResult()
            if (result > 0) {
                callback.onSuccess(result)
            } else {
                callback.onFailure()
            }
        }.run()
    }
}

interface SyncDummyCallback {
    fun onSuccess(result: Int)
    fun onFailure()
}

