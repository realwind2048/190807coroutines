package com.buzzvil.buzzscreen.a190807coroutines.flow

import com.buzzvil.buzzscreen.a190807coroutines.old.Data
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Flow 구현은 같은 coroutine 에서 이뤄져야한다. 다른 코루틴을 쓰고싶으면 channelFlow 를 사용한다
 *
 * Exception transparency
 * catch operator = upstream
 * collect =
 */

class Flow1 {
    fun flowTest1() {
        GlobalScope.launch {
//            f1()
            f2()
        }
    }

    suspend fun f1() {
        flowOf("A", "B", "C")
            .onEach  { println("1$it") }
            .collect { println("2$it") }
    }

    suspend fun f2() {
        flowOf("A", "B", "C")
            .onEach  { println("1$it")
                Data.loadCampaign(it)
            }
            .buffer()  // <--------------- buffer between onEach and collect
            .collect { println("2$it") }
    }
//
//    fun <T> Flow<T>.merge(other: Flow<T>): Flow<T> = channelFlow {
//        // collect from one coroutine and send it
//        launch {
//            collect { send(it) }
//        }
//        // collect and send from this coroutine, too, concurrently
//        other.collect { send(it) }
//    }
}

//fun <T> contextualFlow(): Flow<T> = channelFlow {
//    // send from one coroutine
//    launch(Dispatchers.IO) {
//        send(computeIoValue())
//    }
//    // send from another coroutine, concurrently
//    launch(Dispatchers.Default) {
//        send(computeCpuValue())
//    }
//}