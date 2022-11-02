package com.example.ecommerceconcept.presentation.splash_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ActivityShoppingBinding
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityShoppingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_EcommerceConcept)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}