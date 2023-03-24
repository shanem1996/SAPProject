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

            val query = "SELECT * FROM users WHERE username = '$username' AND password = '$password'"

            val cursor = db.rawQuery(query, null)

            if (cursor.count > 0) {
                Snackbar.make(view, "Success", Snackbar.LENGTH_LONG).show()
                val home = Intent(this, HomeActivity::class.java)
                startActivity(home)
                db.close()
                cursor.close()
            } else {
                Snackbar.make(view, "Failure", Snackbar.LENGTH_LONG).show()
            }

        }
    }

}