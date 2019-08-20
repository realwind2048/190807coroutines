package com.buzzvil.buzzscreen.a190807coroutines.uc02callback.normal

import android.util.Log
import com.buzzvil.buzzscreen.a190807coroutines.uc02callback.*

class CallbackNormalUseCase(val view: View) {
    fun getData() {
        CallbackClass.getNameFromDb(object : Callback {
            override fun onSuccess(name: String) {
                CallbackClass.getPicturesFromWeb(name, object : CallbackGetPictures {
                    override fun onSuccess(pictures: Pictures) {
                        Log.d("TRACK_DEBUG", "YEAH")
                        view.onSuccess(pictures)
                    }

                    override fun onFailure() {
                        view.onFailure()
                    }
                })
            }

            override fun onFailure() {
                view.onFailure()
            }
        })
    }
}

interface View {
    fun onSuccess(pictures: Pictures)
    fun onFailure()
}

