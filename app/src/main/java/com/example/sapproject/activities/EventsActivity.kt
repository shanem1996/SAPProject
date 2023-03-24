package com.example.sapproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.sapproject.R
import com.example.sapproject.activities.database.DatabaseHelper
import com.example.sapproject.databinding.ActivityEventsBinding

class EventsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.event_list)

        val listView = findViewById<ListView>(R.id.lvEvent)
        val db = DatabaseHelper(this)
        val events = db.getEvents()

        val adapter = EventListAdapter(this, events)
        listView.adapter = adapter
    }
}