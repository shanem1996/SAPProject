package com.example.sapproject.activities

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapproject.activities.database.DatabaseHelper
import com.example.sapproject.databinding.ActivityCreateEventBinding
import com.google.android.material.snackbar.Snackbar

class CreateEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCreateEventBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        val db = DatabaseHelper(this).writableDatabase

        binding.btnCreateEvent.setOnClickListener {
            val name = binding.tfEventName.text.toString()
            val date = binding.tfEventDate.text.toString()
            val desc = binding.tfEventDesc.text.toString()

            val values = ContentValues()
            values.put(DatabaseHelper.COLUMN_EVENT_NAME, name)
            values.put(DatabaseHelper.COLUMN_DATE, date)
            values.put(DatabaseHelper.COLUMN_DESC, desc)

            val newRowId = db.insert(DatabaseHelper.EVENT_TABLE, null, values)
            if (newRowId == -1L) {
                Snackbar.make(view, "Error has occurred", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Success", Snackbar.LENGTH_LONG).show()
                val events = Intent(this, EventsActivity::class.java)
                startActivity(events)

            }
        }



    }
}