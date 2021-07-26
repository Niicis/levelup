package com.example.levelup.model.auth

import com.example.levelup.model.User
import java.time.LocalDateTime

data class Session (
    val id: Int,
    val createdAt: LocalDateTime,
    val token: String,
    val user: User
)