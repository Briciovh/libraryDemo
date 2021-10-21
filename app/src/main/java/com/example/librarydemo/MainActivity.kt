package com.example.librarydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.librarydemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupListeners()
    }

    private fun setupListeners() {
        viewModel.emailValidation.observe(this, {validation ->
            if (!validation.isValid){
                binding.emailTextview.error = validation.message
            }
        })

        viewModel.passwordValidation.observe(this, {validation ->
            if (!validation.isValid){
                binding.passwordTextview.error = validation.message
            }
        })

        viewModel.creditCardValidation.observe(this, {validation ->
            if (!validation.isValid){
                binding.creditCardTextview.error = validation.message
            }
        })
    }
}