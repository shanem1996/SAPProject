package com.example.sapproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Events
import com.example.sapproject.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnEditEvents.setOnClickListener {
            val events = Intent(this, EventsActivity::class.java)
            startActivity(events)
        }

        binding.btnEditUsers.setOnClickListener {
            val users = Intent(this, UsersActivity::class.java)
            startActivity(users)
        }

        binding.btnCreateEvents.setOnClickListener {
            val createEvents = Intent(this, CreateEventActivity::class.java)
            startActivity(createEvents)
        }
    }
}