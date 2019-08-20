package com.buzzvil.buzzscreen.a190807coroutines.uc02callback.normal

import com.buzzvil.buzzscreen.a190807coroutines.uc02callback.Pictures

class CallbackNormalView: View {
    init {
        CallbackNormalUseCase(this).getData()
    }

    override fun onSuccess(pictures: Pictures) {

    }

    override fun onFailure() {

    }
}