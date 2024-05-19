package com.aziqazmi.pizzaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aziqazmi.pizzaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnOrder.setOnClickListener {
            var pizzaSizePrice = 0.0
            var toppingTotal = 0.0

            when {
                binding.radBtnSmall.isChecked -> pizzaSizePrice = 25.0
                binding.radBtnMedium.isChecked -> pizzaSizePrice = 45.0
                binding.radBtnLarge.isChecked -> pizzaSizePrice = 75.0
            }

            if(binding.cBoxOnion.isChecked)
            {
                toppingTotal += 1
            }
            if(binding.cBoxOlive.isChecked)
            {
                toppingTotal += 3
            }
            if(binding.cBoxTomato.isChecked)
            {
                toppingTotal += 2
            }

            binding.tvTotal.text = "Total Order Price = RM ${pizzaSizePrice + toppingTotal}"
        }
    }
}