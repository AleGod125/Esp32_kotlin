package com.example.esp32.UI.control

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esp32.data.model.ApiResponse
import com.example.esp32.data.model.Historial
import com.example.esp32.data.model.LedState
import com.example.esp32.data.model.LedStateUpdate
import com.example.esp32.domain.ControlRepository
import com.example.esp32.domain.HistorialRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class controlViewModel : ViewModel() {
    private val repository = ControlRepository()


    private val _control= MutableLiveData<List<LedState>>()
    val control: LiveData<List<LedState>> = _control

    fun fetchControl() {
        viewModelScope.launch {
            try {
                val response = repository.getLedState()
                _control.postValue(response)
            } catch (e: Exception) {
                Log.e("Error en el Control" , e.toString())
            }
        }
    }

    fun setLedState(name: String, state: Boolean) {
        val request = LedStateUpdate(name, state)
        repository.setLedState(request).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {

                } else {
                    Log.e("Error " , "Led no Actualizado")

                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            }
        })
    }

    fun registrarHistorial(usuario: String, accion: String, dispositivo: String) {
        viewModelScope.launch {
            repository.registrarHistorial(usuario, accion, dispositivo)
        }
    }
}