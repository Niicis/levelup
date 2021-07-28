package com.example.levelup.Retrofit


import com.example.levelup.Retrofit.Interceptor.HeaderInterceptor
import com.example.levelup.Retrofit.InterfaceAPI.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private const val BASE_URL: String =  "http://192.168.198.1:8888/api/" //"http://127.0.0.1:8080/api/" //192.168.198.1

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        val headerInterceptor = HeaderInterceptor()

        OkHttpClient
                .Builder()
                .addInterceptor(headerInterceptor)
                .build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    val apiAuthService : AuthService by lazy{
        retrofit.create(AuthService::class.java)
    }

    val apiUserService : UsersService by lazy{
        retrofit.create(UsersService::class.java)
    }

    val apiExcerciseService : ExcerciseService by lazy{
        retrofit.create(ExcerciseService::class.java)
    }

    val apiComentService : ComentService by lazy{
        retrofit.create(ComentService::class.java)
    }

    val apiResponseService : ResponseService by lazy{
        retrofit.create(ResponseService::class.java)
    }

}
