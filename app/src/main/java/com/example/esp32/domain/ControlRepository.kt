package com.example.esp32.domain

import com.example.esp32.data.model.ApiResponse
import com.example.esp32.data.model.HistorialRequest
import com.example.esp32.data.model.LedStateUpdate
import com.example.esp32.data.network.RetrofitInstance
import retrofit2.Call

class ControlRepository {

    suspend fun getLedState() = RetrofitInstance.api.getLedSate()

     fun setLedState(update: LedStateUpdate): Call<ApiResponse> {
        return RetrofitInstance.api.setLedState(update)
    }


        suspend fun registrarHistorial(usuario: String, accion: String, dispositivo: String): Result<Unit> {
            return try {
                val request = HistorialRequest(usuario, accion, dispositivo)
                val response = RetrofitInstance.api.registrarHistorial(request)
                if (response.isSuccessful) {
                    Result.success(Unit)
                } else {
                    Result.failure(Exception("Error HTTP: ${response.code()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

