package com.example.sapproject.activities

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapproject.activities.database.DatabaseHelper
import com.example.sapproject.databinding.ActivitySignInBinding
import com.google.android.material.snackbar.Snackbar

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dbHelper = DatabaseHelper(this)
        db = dbHelper.readableDatabase

        binding.btnSignIn.setOnClickListener {
            val username = binding.tfUsername.text.toString()
            val password = binding.tfPassword.text.toString()

        }
    }

}