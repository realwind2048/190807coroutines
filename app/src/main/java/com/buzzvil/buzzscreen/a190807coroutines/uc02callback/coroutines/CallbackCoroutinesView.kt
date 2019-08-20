package com.buzzvil.buzzscreen.a190807coroutines.uc02callback.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CallbackCoroutinesView {
    init {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val pictures = CallbackCoroutinesUseCase().getData()
                // update UI with pictures
            } catch (e: Exception) {
                Log.d("TRACK_DEBUG", "hahaha $e")
            }
        }
    }
}