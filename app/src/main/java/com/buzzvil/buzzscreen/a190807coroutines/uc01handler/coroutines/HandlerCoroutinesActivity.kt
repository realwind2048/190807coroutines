package com.buzzvil.buzzscreen.a190807coroutines.uc01handler.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.buzzvil.buzzscreen.a190807coroutines.R
import kotlinx.android.synthetic.main.activity_handler_normal.*
import kotlinx.coroutines.*

class HandlerCoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_normal)

        doSomeWork()
    }

    fun doSomeWork() {
        CoroutineScope(Dispatchers.Main).launch {
            coroutineScope {
                launch {
                    progressBar.visibility = View.VISIBLE
                    loadDataFromWeb()
                    progressBar.visibility = View.GONE
                }
                launch {
                    tvCountDown.visibility = View.VISIBLE
                    for (i in 1..10) {
                        tvCountDown.text = i.toString()
                        delay(1000)
                    }
                    tvCountDown.visibility = View.GONE
                }
            }
        }
    }

    suspend fun loadDataFromWeb() {
        withContext(Dispatchers.IO) {
            delay(3000)
        }
    }
}
