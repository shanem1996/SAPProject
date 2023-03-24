package com.example.sapproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.sapproject.R
import com.example.sapproject.activities.database.DatabaseHelper
import com.example.sapproject.databinding.ActivityUsersBinding

class UsersActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.user_list)

        val listView = findViewById<ListView>(R.id.lvUser)
        val db = DatabaseHelper(this)
        val users = db.getUsers()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users.map { "${it.name} (${it.username})" })
        listView.adapter = adapter

    }



}