package com.buzzvil.buzzscreen.a190807coroutines.uc04syncapi.normal

import android.util.Log

class SyncNormalView {
    init {
        SyncNormalUseCase().excute(object : SyncDummyCallback {
            override fun onSuccess(result: Int) {
                Log.d("TRACK_DEBUG", "SyncNormalView success ")
            }

            override fun onFailure() {

            }
        })
    }
}