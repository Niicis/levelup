package com.example.levelup.Retrofit.InterfaceAPI

import retrofit2.Call
import com.example.levelup.model.User
import com.example.levelup.model.auth.Login
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers


interface UsersService {
    @Headers(
            "Content-Type: application/json"
    )
    @GET("users/signin")
    fun getUser(@Body body: Login): Call<ResponseBody>

    @GET("users/{id}")
    fun getUsersById( id: Int): Call<ResponseBody>

}