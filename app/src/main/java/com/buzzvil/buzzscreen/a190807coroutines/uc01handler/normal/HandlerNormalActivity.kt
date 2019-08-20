package com.buzzvil.buzzscreen.a190807coroutines.uc01handler.normal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.buzzvil.buzzscreen.a190807coroutines.R
import kotlinx.android.synthetic.main.activity_handler_normal.*
import java.lang.Runnable

class HandlerNormalActivity : AppCompatActivity() {

    val handler = Handler()
    val MAX_COUNT = 10
    var currentCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_normal)

        doSomeWork()
    }

    val runnable = object : Runnable {
        override fun run() {
            if (currentCount < MAX_COUNT) {
                tvCountDown.text = currentCount.toString()
                currentCount++
                handler.postDelayed(this, 1000)
            } else {
                tvCountDown.visibility = View.GONE
            }
        }
    }

    val hideProgressBar = object : Runnable {
        override fun run() {
            progressBar.visibility = View.GONE
        }
    }

    fun doSomeWork() {
        progressBar.visibility = View.VISIBLE
        tvCountDown.visibility = View.VISIBLE
        handler.postDelayed(runnable, 1000)
        loadDataFromWeb()
    }

    fun loadDataFromWeb() {
        Thread {
            handler.postDelayed(hideProgressBar, 3000)
        }.run()
    }
}
