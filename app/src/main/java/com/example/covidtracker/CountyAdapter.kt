package com.example.covidtracker

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CountyAdapter(var dataSet: List<CountyData>?) : RecyclerView.Adapter<CountyAdapter.ViewHolder>() {

    companion object {
        val EXTRA_COUNTY = "county"
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCounty: TextView
        val textViewLastUpdated: TextView
        val textViewPer100k: TextView
        val layout: ConstraintLayout

        init {
            textViewCounty = view.findViewById(R.id.textView_countyItem_county)
            textViewLastUpdated = view.findViewById(R.id.textView_countyItem_lastUpdatedDate)
            textViewPer100k = view.findViewById(R.id.textView_countyItem_weeklyCasesPer100k)
            layout = view.findViewById(R.id.layout_countyItem)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_county_data, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val county = dataSet?.get(position)
        viewHolder.textViewCounty.text = county?.county
        //viewHolder.textViewCounty.setCompoundDrawables(Drawable())
        viewHolder.textViewLastUpdated.text = county?.lastUpdatedDate
        viewHolder.textViewPer100k.text = county?.metrics?.weeklyNewCasesPer100k.toString()
        viewHolder.layout.setOnClickListener {
            //Toast.makeText(it.context, county.toString(), Toast.LENGTH_SHORT).show()
            val detailIntent = Intent(it.context, CountyDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_COUNTY, county)

            it.context.startActivity(detailIntent)
        }
    }

     override fun getItemCount() = dataSet?.size ?: 0
}