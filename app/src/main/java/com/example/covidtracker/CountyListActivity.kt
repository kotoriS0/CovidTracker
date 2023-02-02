package com.example.covidtracker

import android.net.wifi.rtt.CivicLocationKeys.STATE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidtracker.databinding.ActivityCountyListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CountyListActivity : AppCompatActivity() {
    companion object {
        const val TAG = "CountyListActivity"
        const val STATE = "CA"
    }

    private lateinit var binding: ActivityCountyListBinding
    lateinit var adapter: CountyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountyListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCountyDataByStateApiCall(STATE)
    }

    private fun getCountyDataByStateApiCall(state: String) {
        // create instance of Retrofit with base url and service interface with get requests
        val covidDataService = RetrofitHelper.getInstance().create(CovidDataService::class.java)

        val countyDataCall = covidDataService.getCountyDataByState(state, Constants.API_KEY)

        // execute call object and make async call
        // new CallBack<List<CountyData>> { // method implementations }
        countyDataCall.enqueue(object: Callback<List<CountyData>> {
            override fun onResponse(
                call: Call<List<CountyData>>,
                response: Response<List<CountyData>>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
                adapter = CountyAdapter(response.body())
                binding.recyclerViewCountyList.adapter = adapter
                binding.recyclerViewCountyList.layoutManager = LinearLayoutManager(this@CountyListActivity)

            }

            override fun onFailure(call: Call<List<CountyData>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })


    }
}