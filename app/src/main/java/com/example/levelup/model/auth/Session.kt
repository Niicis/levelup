package com.example.levelup.model.auth

import com.example.levelup.model.User
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Session (
    @SerializedName("id") val id: Int,
    @SerializedName("createdAt") val createdAt: LocalDateTime,
    @SerializedName("token") val token: String,
    @SerializedName("user") val user: User
)