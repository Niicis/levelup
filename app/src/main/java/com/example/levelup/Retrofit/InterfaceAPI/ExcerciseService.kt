package com.example.levelup.Retrofit.InterfaceAPI

import com.example.levelup.model.Exercise
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ExcerciseService {
    @Headers(
            "Content-Type: application/json"
    )
    @GET("exercises/all")
    fun getExcercises(): Call<MutableList<Exercise>>

    @GET("exercises/{id}")
    fun getOneExcercises(@Path("id") id: Int): Call<Exercise>
}