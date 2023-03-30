package com.example.sapproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapproject.activities.model.Event
import com.example.sapproject.databinding.ActivityEventsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class EventsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventsBinding
    private val firestore = FirebaseFirestore.getInstance()
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityEventsBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val userId = currentUser!!.uid
        val userDocRef = firestore.collection("User").document(userId)
        val eventCollectionRef = userDocRef.collection("Event")

        eventCollectionRef.get().addOnSuccessListener { querySnapshot ->
            val myDataList = mutableListOf<Event>()
            for (document in querySnapshot.documents) {
                val myData = document.toObject<Event>()
                if (myData != null) {
                    myDataList.add(myData)
                }
            }

        }


    }
}