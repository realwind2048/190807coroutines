package com.buzzvil.buzzscreen.a190807coroutines.uc05retrofit.normal

import android.util.Log

class RetrofitNormalView {

    init {
        callNormalRetrofit()
    }

    private fun callNormalRetrofit() {
        val retrofitNormalTest = RetrofitNormalTest(object: GetListResult {
            override fun onFailure() {
                Log.d("TRACK_DEBUG", "onFailure")
            }

            override fun onSuccess(repos: List<Repo>?) {
                Log.d("TRACK_DEBUG", "onSuccess")
                repos?.forEach {
                    Log.d("TRACK_DEBUG", "${it.name}")
                }
            }
        })
        retrofitNormalTest.getList()
    }
}
