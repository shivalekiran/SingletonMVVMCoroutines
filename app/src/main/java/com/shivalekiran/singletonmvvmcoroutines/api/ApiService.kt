package com.shivalekiran.singletonmvvmcoroutines.api

import com.shivalekiran.singletonmvvmcoroutines.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("placeholder/user/{userId}")
    suspend fun  getUser(
        @Path("userId") user:String
    ) :User

}