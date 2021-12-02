package com.gmm.twittmap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmm.twittmap.R
import com.gmm.twittmap.model.Data
import com.gmm.twittmap.model.Twitt

class CustomAdapter(private val context: Context, private var dataSet: ArrayList<Data>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val twit: TextView
        val lat:TextView
        val lng: TextView
        init {
            twit = view.findViewById(R.id.twit)
            lat = view.findViewById(R.id.lat)
            lng = view.findViewById(R.id.lng)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val twit=dataSet[position]
        viewHolder.twit.text = twit.text
        viewHolder.lat.text = twit?.geo?.coordinates?.coordinates?.get(0)?.toString()
        viewHolder.lng.text = twit?.geo?.coordinates?.coordinates?.get(1)?.toString()
    }

    override fun getItemCount() = dataSet.size

    fun setTwit(twitList:ArrayList<Data>){
        this.dataSet=twitList
        notifyDataSetChanged()
    }
}