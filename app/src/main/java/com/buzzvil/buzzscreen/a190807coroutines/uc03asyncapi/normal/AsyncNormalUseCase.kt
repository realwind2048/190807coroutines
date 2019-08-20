package com.buzzvil.buzzscreen.a190807coroutines.uc03asyncapi.normal

import com.buzzvil.buzzscreen.a190807coroutines.uc03asyncapi.AsyncDummyCallback
import com.buzzvil.buzzscreen.a190807coroutines.uc03asyncapi.AsyncDummyClass

class AsyncNormalUseCase {
    fun excute(view: AsyncNormalViewInterface) {
        AsyncDummyClass.veryDifficultResult(object : AsyncDummyCallback {
            override fun onSuccess(result: Int) {
                view.onSuccess(result)
            }

            override fun onFailure() {
                view.onFailure()
            }
        })
    }
}

interface AsyncNormalViewInterface {
    fun onSuccess(result: Int)
    fun onFailure()
}