package com.example.esp32.UI.Historial

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esp32.data.model.Historial
import com.example.esp32.domain.HistorialRepository
import kotlinx.coroutines.launch

class historialViewModel : ViewModel() {
    private val repository = HistorialRepository()

    private val _historial= MutableLiveData<List<Historial>>()
    val historial: LiveData<List<Historial>> = _historial

    fun fetchHistorial() {
        viewModelScope.launch {
            try {
                val response = repository.getHistorial()
                _historial.postValue(response)
            } catch (e: Exception) {
                Log.e("Error en el Historial" , e.toString())
            }
        }
    }
}