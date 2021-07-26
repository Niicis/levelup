package com.example.levelup.model

import java.time.LocalDateTime

data class Response (
    val id: Int,
    val user_id: Int,
    val exercise_id: Int,
    val code_sent: String,
    val date: LocalDateTime
)
