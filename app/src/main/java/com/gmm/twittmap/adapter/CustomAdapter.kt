package com.gmm.twittmap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmm.twittmap.R
import com.gmm.twittmap.model.Twitt

class CustomAdapter(private val context: Context, private var dataSet: ArrayList<Twitt>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.textView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val post=dataSet[position]
        viewHolder.textView.text = post.body

    }

    override fun getItemCount() = dataSet.size

    fun setTwit(twitList:ArrayList<Twitt>){
        this.dataSet=twitList
        notifyDataSetChanged()
    }
}