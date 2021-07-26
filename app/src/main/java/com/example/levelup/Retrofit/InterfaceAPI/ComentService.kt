package com.example.levelup.Retrofit.InterfaceAPI

import okhttp3.ResponseBody
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ComentService {
    @Headers(
            "Content-Type: application/json",
            "No-Authentication: skipInterceptor"
    )
    @POST("coment/add")
    fun addComment(@Body body: Comment): Call<ResponseBody>

    @POST("coment/response")
    fun getComment(@Body body: Comment): Call<ResponseBody>

}