package com.buzzvil.buzzscreen.a190807coroutines.uc04asyncapi.normal

import android.util.Log

class AsyncNormalView {
    init {
        AsyncNormalUseCase().excute(object : AsyncNormalViewInterface {
            override fun onSuccess(result: Int) {
                Log.d("TRACK_DEBUG", "onSuccess")
                // update UI
            }

            override fun onFailure() {
                // update UI
            }
        })
    }
}
