package com.example.covidtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covidtracker.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewInfoActivity.text = "Red: High Transmission\nOrange: Substantial Transmission\nYellow: " +
                "Moderate Transmission\nBlue: Low Transmission\nGrey: Unknown\n\nThe number represents " +
                "the weekly case count per 100k people in the county."
    }
}