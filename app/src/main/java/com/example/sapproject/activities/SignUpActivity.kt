package com.example.sapproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sapproject.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val firestore = FirebaseFirestore.getInstance()
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener {
            val email = binding.tfEmail.text.toString().trim()
            val password = binding.tfPassword.text.toString().trim()
            val confPassword = binding.tfConfPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty() && confPassword.isNotEmpty()) {
                if (password != confPassword) {
                    Snackbar.make(view, "Passwords do not match", Snackbar.LENGTH_LONG).show()
                } else {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful) {
                            val currentUser = FirebaseAuth.getInstance().currentUser
                            val userId = currentUser!!.uid
                            val userDocRef = firestore.collection("User").document(userId)

                            val user = hashMapOf(
                                "email" to email
                            )

                            userDocRef.set(user).addOnSuccessListener {
                                Snackbar.make(view, "Success", Snackbar.LENGTH_LONG).show()
                            }

                        } else {
                            Snackbar.make(view, "Failure", Snackbar.LENGTH_LONG).show()
                        }
                    }
                }
            } else {
                Snackbar.make(view, "Fields must be filled", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}