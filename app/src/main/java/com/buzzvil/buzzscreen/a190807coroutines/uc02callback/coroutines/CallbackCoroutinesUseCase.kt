package com.buzzvil.buzzscreen.a190807coroutines.uc02callback.coroutines

import com.buzzvil.buzzscreen.a190807coroutines.uc02callback.NonCallbackClass
import com.buzzvil.buzzscreen.a190807coroutines.uc02callback.Pictures
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CallbackCoroutinesUseCase {
    suspend fun getData(): Pictures {
        return withContext(Dispatchers.IO) {
            val name = NonCallbackClass.getNameFromDb()
            NonCallbackClass.getPicturesFromWeb(name)
        }
    }
}