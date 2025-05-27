package com.example.esp32.UI.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.esp32.R
import com.example.esp32.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.btnIncio.setOnClickListener {
            binding.textI.isVisible = !binding.textI.isVisible
            val icon = if (binding.textI.isVisible) {
                R.drawable.outline_arrow_drop_up_24
            } else {
                R.drawable.outline_arrow_drop_down_24
            }
            binding.btnIncio.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_cloud_lock_24, 0, icon, 0)
        }

        binding.btnControl.setOnClickListener {
            binding.textC.isVisible = !binding.textC.isVisible
            val icon = if (binding.textC.isVisible) {
                R.drawable.outline_arrow_drop_up_24
            } else {
                R.drawable.outline_arrow_drop_down_24
            }
            binding.btnControl.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_cloud_lock_24, 0, icon, 0)
        }

        binding.btnHistorial.setOnClickListener {
            binding.textH.isVisible = !binding.textH.isVisible
            val icon = if (binding.textH.isVisible) {
                R.drawable.outline_arrow_drop_up_24
            } else {
                R.drawable.outline_arrow_drop_down_24
            }
            binding.btnHistorial.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_calendar_clock_24, 0, icon, 0)
        }

        binding.btnGeneracion.setOnClickListener {
            binding.textG.isVisible = !binding.textG.isVisible
            val icon = if (binding.textG.isVisible) {
                R.drawable.outline_arrow_drop_up_24
            } else {
                R.drawable.outline_arrow_drop_down_24
            }
            binding.btnGeneracion.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_cloud_lock_24, 0, icon, 0)
        }

        binding.btnInfo.setOnClickListener {
            binding.textInfo.isVisible = !binding.textInfo.isVisible
            val icon = if (binding.textInfo.isVisible) {
                R.drawable.outline_arrow_drop_up_24
            } else {
                R.drawable.outline_arrow_drop_down_24
            }
            binding.btnInfo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_cloud_lock_24, 0, icon, 0)
        }

        binding.btnDise.setOnClickListener {
            binding.textD.isVisible = !binding.textD.isVisible
            val icon = if (binding.textD.isVisible) {
                R.drawable.outline_arrow_drop_up_24
            } else {
                R.drawable.outline_arrow_drop_down_24
            }
            binding.btnDise.setCompoundDrawablesWithIntrinsicBounds(R.drawable.outline_cloud_lock_24, 0, icon, 0)
        }
        return binding.root
    }
}