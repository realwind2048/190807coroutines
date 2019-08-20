package com.buzzvil.buzzscreen.a190807coroutines.uc03syncapi

object SyncDummyClass {
    fun veryDifficultBlockingCallWithResult(): Int {
        var result = 0
        for (i in 1..1000) {
            result += i
        }
        return result
     }
}