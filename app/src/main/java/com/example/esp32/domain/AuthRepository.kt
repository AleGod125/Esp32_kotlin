package com.example.esp32.domain

import com.example.esp32.data.model.LoginRequest
import com.example.esp32.data.model.LoginResponse
import com.example.esp32.data.network.RetrofitInstance

class AuthRepository {

    suspend fun login(email: String, password: String): Result<LoginResponse> {
        return try {
            val request = LoginRequest(email, password)
            val response = RetrofitInstance.api.login(request)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
