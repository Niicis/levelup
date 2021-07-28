package com.example.levelup.model.auth

import com.google.gson.annotations.SerializedName

data class Login (
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
    )