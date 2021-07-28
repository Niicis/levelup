package com.example.levelup.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: String = "",
    @SerializedName("username") val username: String = "",
    @SerializedName("firstname") val first_name: String = "",
    @SerializedName("lastname") val last_name: String = "",
    @SerializedName("password") val password: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("role") val role: String ="USER"
)