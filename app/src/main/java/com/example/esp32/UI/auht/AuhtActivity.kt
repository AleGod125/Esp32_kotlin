package com.example.esp32.UI.auht

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.esp32.UI.main.MainActivity
import com.example.esp32.databinding.ActivityAuhtBinding

class AuhtActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuhtBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuhtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observa el resultado una sola vez
        viewModel.loginResult.observe(this) { result ->
            result.onSuccess { response ->
                val sharedPref = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("username", response.username)
                    apply()
                }

                // Navegar a HomeActivity pasando el username por Intent
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", response.username)
                startActivity(intent)
                finish()
            }.onFailure { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción del botón
        binding.btnLoguin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.appCompatEditText.text.toString()
            viewModel.login(email, password)
        }
    }
}
