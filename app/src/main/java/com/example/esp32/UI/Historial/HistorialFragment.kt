package com.example.esp32.UI.Historial

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esp32.UI.Historial.adaptes.HistorialAdapter
import com.example.esp32.databinding.FragmentHIstorialBinding

class HistorialFragment : Fragment() {


    private var _binding: FragmentHIstorialBinding? = null
    private val binding get() = _binding!!

    private val viewModel: historialViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHIstorialBinding.inflate(layoutInflater, container, false)

        getHistorial()

        return binding.root
    }

    private fun getHistorial() {
        viewModel.historial.observe(viewLifecycleOwner, Observer { lista  ->
            binding.recyclerHistorial.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = HistorialAdapter(lista)
            }
        })

        viewModel.fetchHistorial()
    }
}