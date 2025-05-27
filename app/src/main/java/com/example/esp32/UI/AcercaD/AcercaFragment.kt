package com.example.esp32.UI.AcercaD

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.esp32.R
import com.example.esp32.databinding.FragmentAcercaBinding
import com.example.esp32.databinding.FragmentControlBinding


class AcercaFragment : Fragment() {
    private var _binding: FragmentAcercaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAcercaBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

}