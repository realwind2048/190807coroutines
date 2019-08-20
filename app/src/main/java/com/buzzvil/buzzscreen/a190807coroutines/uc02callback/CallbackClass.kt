package com.buzzvil.buzzscreen.a190807coroutines.uc02callback

object CallbackClass {
    fun getNameFromDb(callback: Callback) {
        callback.onSuccess("name")
    }

    fun getPicturesFromWeb(name: String, callback: CallbackGetPictures) {
        val pictures = Pictures(name)
        callback.onSuccess(pictures)
    }
}

interface Callback {
    fun onSuccess(name: String)
    fun onFailure()
}

interface CallbackGetPictures {
    fun onSuccess(pictures: Pictures)
    fun onFailure()
}

class Pictures(val name: String) {

}