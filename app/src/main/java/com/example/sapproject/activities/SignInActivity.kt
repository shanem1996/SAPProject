package com.example.sapproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sapproject.databinding.ActivitySignInBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSignIn.setOnClickListener {
            val email = binding.tfEmail.text.toString().trim()
            val password = binding.tfPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val currentUser = FirebaseAuth.getInstance().currentUser
                        val userId = currentUser!!.uid
                        val userDocRef = firestore.collection("User").document(userId)

                        userDocRef.get().addOnSuccessListener { documentSnapshot ->
                            val admin = documentSnapshot.getBoolean("admin")
                            if (admin != null && admin) {
                                val adminHome = Intent(this, AdminHomeActivity::class.java)
                                startActivity(adminHome)

                            } else {
                                val home = Intent(this, HomeActivity::class.java)
                                startActivity(home)
                            }
                            Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT)
                                .show()
                        }


                    } else {
                        Snackbar.make(
                            view,
                            "Login Failed - Invalid email or password",
                            Snackbar.LENGTH_LONG
                        ).show()

                    }
                }
            }
        }
    }
}