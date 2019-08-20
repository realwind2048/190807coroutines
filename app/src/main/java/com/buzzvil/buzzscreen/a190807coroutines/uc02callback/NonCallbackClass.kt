package com.buzzvil.buzzscreen.a190807coroutines.uc02callback

object NonCallbackClass {
    fun getNameFromDb(): String {
        // Do some hard work
        return "name"
    }

    fun getPicturesFromWeb(name: String): Pictures {
        return Pictures(name)
    }
}