package com.example.sapproject.activities.viewholder

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.sapproject.R

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.tfEventNameItem)
    val date = itemView.findViewById<TextView>(R.id.tfEventDateItem)
}