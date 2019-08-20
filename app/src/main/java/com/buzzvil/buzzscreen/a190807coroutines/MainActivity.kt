package com.buzzvil.buzzscreen.a190807coroutines

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buzzvil.buzzscreen.a190807coroutines.uc01handler.coroutines.HandlerCoroutinesActivity
import com.buzzvil.buzzscreen.a190807coroutines.uc01handler.normal.HandlerNormalActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // uc01 retrofit
//        RetrofitNormalView()()
//        RetrofitCoroutinesView()

        // uc02 callback
//        CallbackNormalView()
//        CallbackCoroutinesView()

        // uc03 asyncApi
//        AsyncNormalView()
//        AsyncCoroutinesView()

        // uc04 syncApi
//        SyncNormalView()
//        SyncCoroutinesView()

        // uc05 handler
//        showHandlerNormalActivity()
        showHandlerCoroutinesActivity()

    }

    private fun showHandlerNormalActivity() {
        val intent = Intent(this, HandlerNormalActivity::class.java)
        startActivity(intent)
    }

    private fun showHandlerCoroutinesActivity() {
        val intent = Intent(this, HandlerCoroutinesActivity::class.java)
        startActivity(intent)
    }
}
