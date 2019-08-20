package com.buzzvil.buzzscreen.a190807coroutines.uc04asyncapi

object AsyncDummyClass {
    fun veryDifficultResult(callback: AsyncDummyCallback) {
        Thread {
            var result = 0
            for (i in 1..1000) {
                result += i
            }

            if (result == 0) {
                callback.onFailure()
            } else {
                callback.onSuccess(result)
            }
        }.run()
    }
}

interface AsyncDummyCallback {
    fun onSuccess(result: Int)
    fun onFailure()
}