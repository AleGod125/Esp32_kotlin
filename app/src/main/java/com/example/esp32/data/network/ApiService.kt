package com.example.esp32.data.network

import com.example.esp32.data.model.ApiResponse
import com.example.esp32.data.model.Historial
import com.example.esp32.data.model.HistorialRequest
import com.example.esp32.data.model.LedState
import com.example.esp32.data.model.LedStateUpdate
import com.example.esp32.data.model.LoginRequest
import com.example.esp32.data.model.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("Gethistorial")
    suspend fun getHistorial(): List<Historial>

    @GET("led_states")
    suspend fun getLedSate(): List<LedState>

    @POST("/set_led_state")
    fun setLedState(@Body request: LedStateUpdate): Call<ApiResponse>

    @POST("/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("/historial")
    suspend fun registrarHistorial(@Body request: HistorialRequest): Response<Unit>

}