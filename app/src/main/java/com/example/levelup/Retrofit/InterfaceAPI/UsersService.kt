package com.example.levelup.Retrofit.InterfaceAPI

import android.telecom.Call
import com.example.levelup.model.auth.Login
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers


interface UsersService {
    @Headers(
            "Content-Type: application/json",
            "No-Authentication: skipInterceptor"
    )
    @GET("users/signin")
    fun getUser(@Body body: Login): Call

    @GET("users/{id}")
    fun getUsersById( id: Int): Call

}