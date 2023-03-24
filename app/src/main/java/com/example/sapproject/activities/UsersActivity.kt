package com.example.sapproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapproject.databinding.ActivityUsersBinding

class UsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}