package com.example.esp32.data.model

data class LoginRequest(
    val email: String,
    val password: String
)


data class LoginResponse(
    val exists: Boolean,
    val username: String?, // nullable porque puede no venir
    val error: String? // nullable porque puede no haber error
)
