package com.shivalekiran.singletonmvvmcoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.shivalekiran.singletonmvvmcoroutines.models.User
import com.shivalekiran.singletonmvvmcoroutines.repository.Repository

class UserViewModel : ViewModel() {
    private val _userId: MutableLiveData<String> = MutableLiveData()
    val user: LiveData<User> = Transformations
        .switchMap(_userId) { userId ->
            Repository.getUser(userId)
        }

    fun setUserId(userId :String) {
        val update = userId
        if (_userId.value == update) return
        _userId.value = update
    }

    fun cancelJob(){
        Repository.cancelJob()
    }
}