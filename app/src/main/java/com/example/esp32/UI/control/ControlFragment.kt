package com.example.esp32.UI.control

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esp32.UI.control.Adapter.LedAdapter
import com.example.esp32.databinding.FragmentControlBinding
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ControlFragment : Fragment() {
    private var _binding: FragmentControlBinding? = null
    private val binding get() = _binding!!
    private val viewModel: controlViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentControlBinding.inflate(inflater, container, false)

        var username = "Android"
        parentFragmentManager.setFragmentResultListener("user_key", viewLifecycleOwner) { _, bundle ->
            username = bundle.getString("username", "Android")
        }



        viewModel.control.observe(viewLifecycleOwner) { leds ->
            binding.recyclerView.adapter = LedAdapter(leds) { led ->
                val nuevoEstado = !led.state
                viewModel.setLedState(led.name, nuevoEstado)
                val accion = if (nuevoEstado) "encender" else "apagar"
                viewModel.registrarHistorial(username, accion, led.name)
                Toast.makeText(requireContext(), "${led.name} se ${accion}á exitosamente", Toast.LENGTH_SHORT).show()
                Toast.makeText(requireContext(), "${led.name} cambió exitosamente", Toast.LENGTH_SHORT).show()
            }
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        lifecycleScope.launch {
           while (true) {
        delay(5000)
               viewModel.fetchControl()
           }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
