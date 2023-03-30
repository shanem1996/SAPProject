package com.example.sapproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapproject.activities.model.Event
import com.example.sapproject.databinding.ActivityEventsBinding
import com.example.sapproject.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val firestore = FirebaseFirestore.getInstance()
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnCreateEvent.setOnClickListener {
            val date = binding.date.text.toString().trim()
            val name = binding.tfEventName.text.toString().trim()

            val currentUser = FirebaseAuth.getInstance().currentUser
            val userId = currentUser!!.uid
            val userDocRef = firestore.collection("User").document(userId)
            val eventDocRef = userDocRef.collection("Event")

            val event = hashMapOf(
                "name" to name,
                "date" to date
            )

            eventDocRef.add(event).addOnSuccessListener {
                Snackbar.make(view, "Success", Snackbar.LENGTH_LONG).show()
                val events = Intent(this, EventsActivity::class.java)
                startActivity(events)
            }

        }

        binding.btnEvents.setOnClickListener {
            val events = Intent(this, EventsActivity::class.java)
            startActivity(events)
        }
    }
}