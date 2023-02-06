package com.example.covidtracker

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
// variable name must match the api json name
data class CountyData(
    val state: String?,
    val county: String?,
    val cdcTransmissionLevel: Int,
    val lastUpdatedDate: String,
    val actuals: Actuals,
    val metrics: Metrics
) :Parcelable {
    @Parcelize
    data class Actuals (
        val cases: Int?,
        val newCases: Int?
    ) :Parcelable

    @Parcelize
    data class Metrics (
        val testPositivityRatio: Double?,
        val weeklyNewCasesPer100k: Double?
    ) :Parcelable
}
