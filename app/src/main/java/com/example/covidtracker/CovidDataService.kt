package com.example.covidtracker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CovidDataService {
    // make functions to retrieve data from endpoints

    // get county data for all counties in a state
    // only include path to file, query params handled in fun params
    @GET("county/{state}.json")
    fun getCountyDataByState(
        @Path("state") state: String,
        @Query("apiKey") apiKey: String) : Call<List<CountyData>>
}