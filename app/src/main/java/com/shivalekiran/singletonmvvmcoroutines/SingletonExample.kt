package com.shivalekiran.singletonmvvmcoroutines

import com.shivalekiran.singletonmvvmcoroutines.models.User

object SingletonExample {
    val singleUser : User by lazy {
        User("","","")
    }
}