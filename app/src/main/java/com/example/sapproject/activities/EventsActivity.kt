package com.example.sapproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapproject.databinding.ActivityEventsBinding
import com.example.sapproject.databinding.ActivityUsersBinding

class EventsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}