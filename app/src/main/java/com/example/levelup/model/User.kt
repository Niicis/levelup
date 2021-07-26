package com.example.levelup.model

data class User(
    val id: String = "",
    val username: String = "",
    val first_name: String = "",
    val last_name: String = "",
    val password: String = "",
    val email: String = "",
    val role: String ="USER"
)