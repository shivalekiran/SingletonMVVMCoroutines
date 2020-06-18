package com.shivalekiran.singletonmvvmcoroutines.repository

import androidx.lifecycle.LiveData
import com.shivalekiran.singletonmvvmcoroutines.api.MyRetrofitBuilder
import com.shivalekiran.singletonmvvmcoroutines.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {
    var job: CompletableJob? = null
    fun getUser(userId: String): LiveData<User> {
        job = Job()
        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let { job ->
                    CoroutineScope( IO + job).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(userId)
                        withContext(Main) {
                            value = user
                            job.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJob() {
        job?.cancel()
    }
}