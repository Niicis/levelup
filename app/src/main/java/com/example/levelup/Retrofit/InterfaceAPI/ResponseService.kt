package com.example.levelup.Retrofit.InterfaceAPI


import com.example.levelup.model.Response
import okhttp3.ResponseBody
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.GET

interface ResponseService {


    @GET("responses/user/{user_id}")
    fun login(@Body body: Response): Call<ResponseBody>

    @GET("responses/excercise/{excercise_id}")
    fun getComentExcersie(@Body body: Response): Call<ResponseBody>

    @GET("responses/{id}")
    fun getComentId(@Body body: Response): Call<ResponseBody>
}