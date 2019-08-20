package com.buzzvil.buzzscreen.a190807coroutines.flow

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

class Flow {
    fun hotSteam() {
        runBlocking<Unit> {
            val producer = produce<Int>(capacity = 2) {
                println("producer body")

                (0..100).forEach {
                    send(it)
                    println("send $it")
                }
            }
//            println("producer done")
        }

    }

    fun flowTest1() {
//        flow {
//            emit(1) // Ok
//            withContext(Dispatchers.IO) {
//                emit(2) // Will fail with ISE
//            }
//        }

//        val intFlow = flow {
//            for (i in 0 until 10) {
//                emit(i) //calls emit directly from the body of a FlowCollector
//            }
//        }

//        flowViaChannel<Int>(10) { channel ->
//            (0..20).forEach {
//                channel.send(it) //items sent will be emitted via FlowCollector
//            }
//        }
    }
}