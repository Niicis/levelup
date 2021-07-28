package com.example.levelup.Retrofit.InterfaceAPI

import com.example.levelup.model.Comment
import okhttp3.ResponseBody

import retrofit2.Call
import retrofit2.http.*

interface ComentService {
    @Headers(
            "Content-Type: application/json"
    )
    @POST("comment/add")
    fun addComment(@Body body: Comment): Call<ResponseBody>

    @GET("comment/response/{id}")
    fun getComment(@Path("id") id: Int): Call<MutableList<Comment>>

}