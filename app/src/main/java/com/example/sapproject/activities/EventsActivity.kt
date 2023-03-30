package com.example.sapproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.sapproject.activities.adapter.MyAdapter
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
        val recyclerView: RecyclerView = binding.recyclerView
        val adapter = MyAdapter(emptyList())

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        eventCollectionRef.get().addOnSuccessListener { querySnapshot ->
            val myDataList = querySnapshot.documents.map { documentSnapshot ->
                val myData = documentSnapshot.toObject<Event>()
                myData
            }
            adapter.setData(myDataList as List<Event>)

        }


    }
}