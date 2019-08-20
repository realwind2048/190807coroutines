package com.buzzvil.buzzscreen.a190807coroutines.uc04asyncapi.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AsyncCoroutinesView {
    init {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = AsyncCoroutinesUseCase().excute()
                Log.d("TRACK_DEBUG", "AsyncCoroutinesView success")
                // update ui with result
            } catch (e: Exception) {
                Log.d("TRACK_DEBUG", "e = $e")
            }
        }
    }
}
