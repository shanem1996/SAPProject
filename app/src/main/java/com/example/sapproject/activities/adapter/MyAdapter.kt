package com.example.sapproject.activities.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sapproject.R
import com.example.sapproject.activities.model.Event
import com.example.sapproject.activities.viewholder.MyViewHolder

class MyAdapter(private val data: List<Event>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = data[position]
        holder.name.text = currentItem.name
        holder.date.text = currentItem.date
    }

    override fun getItemCount() = data.size
}
