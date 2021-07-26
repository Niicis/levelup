package com.example.levelup.Retrofit.Interceptor

import android.annotation.SuppressLint
import android.util.Log
import com.example.levelup.Preferences.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    @SuppressLint("LongLogTag")
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {

        Log.d("--- HeaderInterceptor ---", "interceptor")

        val request = chain.request()

        if (request.header("No-Authentication") != null) {
            Log.d("--- HeaderInterceptor ---", "token no auth")
            return chain.proceed(request)
        }

        val token: String? = AppPreferences.token

        if (token == null && token == "") {
            Log.d("--- HeaderInterceptor ---", "token null")
            return chain.proceed(request)
        }

        Log.d("--- HeaderInterceptor ---", "add header Authorization : $token")

        proceed(
            request()
                .newBuilder()
                .addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .build()
        )
    }
}