package com.example.esp32.domain

import com.example.esp32.data.network.RetrofitInstance

class HistorialRepository {
    suspend fun getHistorial() = RetrofitInstance.api.getHistorial()
}