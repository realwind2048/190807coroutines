package com.buzzvil.buzzscreen.a190807coroutines

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buzzvil.buzzscreen.a190807coroutines.old.FlowMainActivity
import com.buzzvil.buzzscreen.a190807coroutines.uc01handler.coroutines.HandlerCoroutinesActivity
import com.buzzvil.buzzscreen.a190807coroutines.uc01handler.normal.HandlerNormalActivity
import com.buzzvil.buzzscreen.a190807coroutines.uc03syncapi.coroutines.SyncCoroutinesView
import com.buzzvil.buzzscreen.a190807coroutines.uc05retrofit.coroutines.RetrofitCoroutinesView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // uc01 handler
//        showHandlerNormalActivity()
//        showHandlerCoroutinesActivity()

        // uc02 callback
//        CallbackNormalView()
//        CallbackCoroutinesView()

        // uc03 syncApi
//        AsyncNormalView()
//        AsyncCoroutinesView()

        // uc04 asyncApi
//        SyncNormalView()
//        SyncCoroutinesView()

        // uc05 retrofit
//        RetrofitNormalView()()
//        RetrofitCoroutinesView()

        // Flow
//        showFlowActivity()

    }

    private fun showHandlerNormalActivity() {
        val intent = Intent(this, HandlerNormalActivity::class.java)
        startActivity(intent)
    }

    private fun showHandlerCoroutinesActivity() {
        val intent = Intent(this, HandlerCoroutinesActivity::class.java)
        startActivity(intent)
    }

    private fun showFlowActivity() {
        val intent = Intent(this, FlowMainActivity::class.java)
        startActivity(intent)
    }
}
