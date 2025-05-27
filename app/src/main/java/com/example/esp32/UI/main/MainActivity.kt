package com.example.esp32.UI.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.esp32.R
import com.example.esp32.UI.control.ControlFragment
import com.example.esp32.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

        val username = intent.getStringExtra("username")

        supportFragmentManager.setFragmentResult(
            "user_key",
            Bundle().apply { putString("username", username) }
        )

        Toast.makeText(this, "Biembenido!!!, $username!", Toast.LENGTH_SHORT).show()

        val firstLetter = username?.let { if (it.isNotEmpty()) username.first().uppercaseChar() else '?' }
        binding.name.text = firstLetter.toString()


    }

    private fun initUI() {
        InitNavigation()

    }

    private fun InitNavigation() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHost.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}