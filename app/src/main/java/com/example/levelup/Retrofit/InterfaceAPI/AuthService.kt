package com.example.levelup.Retrofit.InterfaceAPI

import com.example.levelup.model.auth.Login
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {
    @Headers(
            "Content-Type: application/json",
            "No-Authentication: skipInterceptor"
    )
    @POST("auth/login")
    fun login(@Body body: Login): Call<ResponseBody>

    @GET("auth/token/{id}")
    fun getToken(@Body body: Int): Call<ResponseBody>
}