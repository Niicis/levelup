package com.example.levelup.model

import com.google.gson.annotations.SerializedName

class Exercise(
    @SerializedName("id") val id: String = "",
    @SerializedName("content") val content: String = "",
    @SerializedName("title") val title: String = ""
)