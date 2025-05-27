package com.example.esp32.UI.Historial.adaptes

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.esp32.R
import com.example.esp32.data.model.Historial
import com.example.esp32.databinding.ItemhistorialBinding

class HistorialAdapter(private val historialList: List<Historial>) :
    RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {

    inner class HistorialViewHolder(val binding: ItemhistorialBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val binding = ItemhistorialBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HistorialViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val item = historialList[position]
        holder.binding.apply {
            txtUsuario.text = item.usuario
            txtAccion.text = item.accion
            txtDispositivo.text = item.dispositivo
            txtFecha.text = item.fecha
        }

        holder.binding.txtAccion.text = item.accion

        // Cambiar estilo dinámicamente
        when (item.accion.lowercase()) {
            "encender" -> {
                holder.binding.txtAccion.setTextColor(Color.GREEN) // Verde
                holder.binding.txtAccion.setBackgroundResource(R.drawable.bg_encender)
            }

            "apagar" -> {
                holder.binding.txtAccion.setTextColor(Color.RED)// Rojo
                holder.binding.txtAccion.setBackgroundResource(R.drawable.bg_apagar)
            }

            else -> {
                holder.binding.txtAccion.setTextColor(Color.GRAY)
            }
        }

    }

    override fun getItemCount(): Int = historialList.size
}
