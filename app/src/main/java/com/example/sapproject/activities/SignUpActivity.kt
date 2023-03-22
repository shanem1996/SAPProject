package com.example.sapproject.activities

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sapproject.activities.database.DatabaseHelper
import com.example.sapproject.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val db = DatabaseHelper(this).writableDatabase

        binding.btnSignUp.setOnClickListener {
            val name = binding.tfName.text.toString()
            val username = binding.tfUsername.text.toString()
            val password = binding.tfPassword.text.toString()

            val values = ContentValues()
            values.put(DatabaseHelper.COLUMN_NAME, name)
            values.put(DatabaseHelper.COLUMN_USERNAME, username)
            values.put(DatabaseHelper.COLUMN_PASSWORD, password)

            val newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values)
            if (newRowId == -1L) {
                Snackbar.make(view, "Error has occurred", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Success", Snackbar.LENGTH_LONG).show()
                val home = Intent(this, HomeActivity::class.java)
                startActivity(home)

            }
        }



    }
}