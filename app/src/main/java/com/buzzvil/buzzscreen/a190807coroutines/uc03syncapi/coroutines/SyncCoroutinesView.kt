package com.buzzvil.buzzscreen.a190807coroutines.uc03syncapi.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SyncCoroutinesView {
    init {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = SyncCoroutinesUseCase().excute()
                // update UI with result
                Log.d("TRACK_DEBUG", "SyncCoroutinesView success ")
            } catch (e: Exception) {
                Log.d("TRACK_DEBUG", "e = $e")
            }
        }
    }
}