package com.example.levelup.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Response (
    @SerializedName("id") val id: Int,
    @SerializedName("userid") val userid: Int,
    @SerializedName("exerciseid") val exerciseid: Int,
    @SerializedName("codeSent") val codeSent: String,
    @SerializedName("status") val status: String,
    @SerializedName("date") val date: String
)
