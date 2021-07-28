package com.example.levelup.Retrofit.InterfaceAPI


import com.example.levelup.model.Response
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.GET
import retrofit2.http.Path

interface ResponseService {
    @Headers(
        "Content-Type: application/json"
    )
    @GET("responses/user/{user_id}")
    fun getResponseByIdUser(@Path("user_id") id: Int): Call<MutableList<Response>>

    @GET("responses/exercise/{exercise_id}")
    fun getResponseByIdEx(@Path("exercise_id") id: Int): Call<MutableList<Response>>

    @GET("responses/{id}")
    fun getReponseById(@Path("id") id: Int): Call<Response>
}