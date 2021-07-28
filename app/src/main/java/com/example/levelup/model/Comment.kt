package com.example.levelup.model

import com.google.gson.annotations.SerializedName
import java.util.*

public class Comment (
        @SerializedName("id") val id: String,
        @SerializedName("response_id") val responseid: Int,
        @SerializedName("user_id") val userid: Int,
        @SerializedName("content") val content: String,
        @SerializedName("date") val date: Date
)