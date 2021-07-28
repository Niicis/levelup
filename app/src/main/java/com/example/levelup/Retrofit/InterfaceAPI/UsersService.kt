package com.example.levelup.Retrofit.InterfaceAPI

import retrofit2.Call
import com.example.levelup.model.User
import com.example.levelup.model.auth.Login
import okhttp3.ResponseBody
import retrofit2.http.*


interface UsersService {
    @Headers(
            "Content-Type: application/json"
    )
    @POST("users/signin")
    fun getUser(@Body body: Login): Call<User>

    @GET("users/{id}")
    fun getUsersById(@Path("id") id: Int): Call<User>

}