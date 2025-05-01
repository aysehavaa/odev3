package com.example.loginapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.loginapp.databinding.ActivityLoginBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Set up view binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up language based on device locale
        setupLanguage()

        // Set up dark mode toggle based on system settings
        setupDarkMode()

        // Set up click listeners
        setupClickListeners()
    }

    private fun setupLanguage() {
        val locale = Locale.getDefault()
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    private fun setupDarkMode() {
        // Follow system dark mode settings
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    private fun setupClickListeners() {
        binding.apply {
            loginButton.setOnClickListener {
                validateAndLogin()
            }

            forgotPassword.setOnClickListener {
                // Handle forgot password
                Toast.makeText(this@MainActivity, "Şifre sıfırlama özelliği yakında eklenecek", Toast.LENGTH_SHORT).show()
            }

            registerButton.setOnClickListener {
                // Handle registration
                Toast.makeText(this@MainActivity, "Kayıt özelliği yakında eklenecek", Toast.LENGTH_SHORT).show()
            }

            googleLogin.setOnClickListener {
                // Handle Google login
                Toast.makeText(this@MainActivity, "Google ile giriş özelliği yakında eklenecek", Toast.LENGTH_SHORT).show()
            }

            facebookLogin.setOnClickListener {
                // Handle Facebook login
                Toast.makeText(this@MainActivity, "Facebook ile giriş özelliği yakında eklenecek", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateAndLogin() {
        binding.apply {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            when {
                email.isEmpty() -> {
                    emailLayout.error = "E-posta adresi gerekli"
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    emailLayout.error = "Geçerli bir e-posta adresi giriniz"
                }
                password.isEmpty() -> {
                    passwordLayout.error = "Şifre gerekli"
                }
                password.length < 6 -> {
                    passwordLayout.error = "Şifre en az 6 karakter olmalıdır"
                }
                else -> {
                    // Clear any errors
                    emailLayout.error = null
                    passwordLayout.error = null
                    
                    // Perform login
                    Toast.makeText(this@MainActivity, "Giriş başarılı!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
} 
