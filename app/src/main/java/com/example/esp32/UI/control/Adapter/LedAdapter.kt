package com.example.esp32.UI.control.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.esp32.R
import com.example.esp32.data.model.LedState
import com.example.esp32.databinding.ItemLedStateBinding

class LedAdapter(
    private val leds: List<LedState>,
    private val onLedToggle: (LedState) -> Unit
) : RecyclerView.Adapter<LedAdapter.LedViewHolder>() {


    inner class LedViewHolder(val binding: ItemLedStateBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LedViewHolder {
        val binding = ItemLedStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LedViewHolder, position: Int) {
        val led = leds[position]
        with(holder.binding) {
            txtNombre.text = led.name
            txtContador.text = "Activaciones: ${led.count}"

            txtEstado.text = if (led.state) "Encendido" else "Apagado"
            txtEstado.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    if (led.state) android.R.color.holo_green_light else android.R.color.holo_red_light
                )
            )

            val backgroundRes = if (led.state) R.drawable.bg_encender else R.drawable.bg_apagar
            txtEstado.background = ContextCompat.getDrawable(holder.itemView.context, backgroundRes)

            val card = layout
            val background = if (led.state) R.drawable.bg_led_on else R.drawable.bg_led_off
            card.setBackgroundResource(background)

            card.setOnClickListener {
                onLedToggle(led)
            }
        }
    }


    override fun getItemCount(): Int = leds.size
}
