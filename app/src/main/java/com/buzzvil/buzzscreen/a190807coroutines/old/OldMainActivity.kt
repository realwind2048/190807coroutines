package com.buzzvil.buzzscreen.a190807coroutines.old

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.buzzvil.buzzscreen.a190807coroutines.R
import com.buzzvil.buzzscreen.a190807coroutines.old.Data.loadCampaign
import com.buzzvil.buzzscreen.a190807coroutines.flow.Flow1
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

class OldMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val campaigns = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
//        GlobalScope.launch {
////            loadAll(campaigns)
//            withTimeout(5000) {
//                loadOne(campaigns)
//            }
//            withContext(Dispatchers.IO) {
//
//            }
//
//            Dispatchers.IO {
//                Log.d("TAG", "Log")
//            }
//
//        }
        val flow = Flow1()
//        flow.hotSteam()
        flow.flowTest1()

    }

    suspend fun loadAll(campaigns: List<String>) {
        val jobs = ArrayList<Deferred<Unit>>()
        campaigns.forEach { campaign ->
            jobs.add(GlobalScope.async { loadCampaign(campaign) })
        }
        jobs.forEach { job ->
            job.await()
        }
        Log.d("TRACK_DEBUG", "loadAll DONE")
    }

    suspend fun loadOne(campaigns: List<String>) {
        campaigns.asFlow()
            .concurrentMap(Dispatchers.IO, 10, 10) {
                loadCampaign(it)
            }
            .take(1)
            .collect {
                Log.d("TRACK_DEBUG", "loadOne")
            }
    }

    private fun <T, R> Flow<T>.concurrentMap(dispatcher: CoroutineDispatcher, concurrencyLevel: Int, bufferSize: Int, transform: suspend (T) -> R): Flow<R> {
        return flatMapMerge(concurrencyLevel) { value ->
            flow { emit(transform(value)) }
        }.flowOn(dispatcher)
    }


}

object Data {
    suspend fun loadCampaign(campaign: String) {
        Log.d("TRACK_DEBUG", "loadCampaign start c - $campaign")
        val randomDelay = Random(System.currentTimeMillis()).nextLong(1000L, 10000L)
        delay(randomDelay)
        Log.d("TRACK_DEBUG", "loadCampaign end c - $campaign")
    }
}

@FlowPreview
fun <T, R> Flow<T>.mapParallel(scope: CoroutineScope, bufferSize: Int = 16, transform: suspend (T) -> R) =
    flow {
        val currentContext = coroutineContext.minusKey(Job) // Jobs are ignored

        coroutineScope {
            val channel = produce(currentContext, capacity = bufferSize) {
                collect { value ->
                    send(scope.async { transform(value) })
                }
            }

            (channel as Job).invokeOnCompletion { if (it is CancellationException && it.cause == null) cancel() }
            for (element in channel) {
                emit(element.await())
            }
//
//            val producer = channel as Job
//            if (producer.isCancelled) {
//                producer.join()
//                throw producer.getCancellationException()
//            }
        }
    }


//fun <T> List<Deferred<T>>.toFlow(): Flow<T> =
//    asFlow()
//        .flatMapMerge { flow { emit(it.await()) } }

//    suspend fun loadOne(campaigns: List<String>) {
//        val jobs = ArrayList<Deferred<Unit>>()
//        campaigns.forEach { campaign ->
//            jobs.add(GlobalScope.async { loadCampaign(campaign) })
//        }
//        jobs.forEach { job ->
//            job.await()
//        }
//        Log.d("TRACK_DEBUG", "loadOne DONE")
//    }
//    suspend fun loadOne(campaigns: List<String>) {
//        campaigns.asFlow()
//            .map {
//                loadCampaign(it)
//            }
////            .take(1)
//            .collect()
//    }
//    suspend fun loadOne(campaigns: List<String>) {
//        val c = campaigns.asFlow()
//            .map {
//                val job = GlobalScope.async {
//                    Log.d("TRACK_DEBUG", "map it = $it")
//                    loadCampaign(it)
//                }
//                job.await()
//            }
////           .take(1)
//            .collect {
//                Log.d("TRACK_DEBUG", "loadAll One")
//            }
//
////        Log.d("TRACK_DEBUG", "loadAll One")
//    }

//fun doDreamCode() {
//    CoroutineScope(Dispatchers.Main).launch {
//        val user = fetchUserData()
//        textView.text = user.name
//    }
//}

