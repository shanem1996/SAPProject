package com.example.sapproject.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.sapproject.R
import com.example.sapproject.activities.models.Event
import com.example.sapproject.activities.models.User
import com.google.android.material.snackbar.Snackbar

class EventListAdapter(context: Context, events: List<Event>) :
    ArrayAdapter<Event>(context, 0, events) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false)
        }

        val currentEvent = getItem(position)
        val nameTextView = listItemView!!.findViewById<TextView>(R.id.tvEventName)
        nameTextView.text = currentEvent!!.eventName

        val dateTextView = listItemView.findViewById<TextView>(R.id.tvEventDate)
        dateTextView.text = currentEvent.date

        val descTextView = listItemView.findViewById<TextView>(R.id.tvEventDesc)
        descTextView.text = currentEvent.desc

        listItemView.setOnClickListener {
            Snackbar.make(parent, "Success: ${currentEvent.eventName}", Snackbar.LENGTH_LONG).show()
        }

        return listItemView

    }
}