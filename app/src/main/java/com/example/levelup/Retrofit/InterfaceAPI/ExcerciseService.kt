package com.example.levelup.Retrofit.InterfaceAPI

import okhttp3.ResponseBody
import retrofit2.Call

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ExcerciseService {
    @Headers(
            "Content-Type: application/json",
            "No-Authentication: skipInterceptor"
    )
    @GET("excercises/all")
    fun getExcercises(): Call<ResponseBody>

    @POST("excercises/{id}")
    fun getOneExcercises(@Body body: Int): Call<ResponseBody>
}