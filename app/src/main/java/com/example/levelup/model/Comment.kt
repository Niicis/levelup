package com.example.levelup.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.util.*

public class Comment (
        @SerializedName("id") val id: Int,
        @SerializedName("responseid") val responseid: Int,
        @SerializedName("userid") val userid: Int,
        @SerializedName("content") val content: String,
        @SerializedName("date") val date: String
)