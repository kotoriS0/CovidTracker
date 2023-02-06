package com.example.covidtracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covidtracker.CountyAdapter.Companion.EXTRA_COUNTY
import com.example.covidtracker.databinding.ActivityCountyDetailBinding

class CountyDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountyDetailBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val county = intent?.getParcelableExtra<CountyData>(EXTRA_COUNTY)

        binding.textViewCountyDetailCounty.text = county?.county
        binding.textViewCountyDetailCdcTransmissionLevel.text = county?.cdcTransmissionLevel.toString()
        binding.textViewCountyDetailLastDateUpdated.text = county?.lastUpdatedDate
        binding.textViewCountyDetailCases.text = county?.actuals?.cases.toString()
        binding.textViewCountyDetailNewCases.text = county?.actuals?.newCases.toString()
        binding.textViewCountyDetailTestPositivityRatio.text = county?.metrics?.testPositivityRatio.toString()
        binding.textViewCountyDetailNewCasesPer100k.text = county?.metrics?.weeklyNewCasesPer100k.toString()
    }
}