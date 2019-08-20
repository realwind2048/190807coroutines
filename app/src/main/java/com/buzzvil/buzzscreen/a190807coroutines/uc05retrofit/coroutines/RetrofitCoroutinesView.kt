package com.buzzvil.buzzscreen.a190807coroutines.uc05retrofit.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitCoroutinesView {

    init {
        callCoroutinesRetrofit()
    }

    private fun callCoroutinesRetrofit() {
        val retrofitCoroutinesTest = RetrofitCoroutinesTest()
        CoroutineScope(Dispatchers.Main).launch {
            try {
                retrofitCoroutinesTest.getList2().forEach {
                    Log.d("TRACK_DEBUG", "${it.name} ")
                }
//                uiUpdate()
            } catch (e: Exception) {
                Log.d("TRACK_DEBUG", "e = $e")
            }
        }
    }
}
