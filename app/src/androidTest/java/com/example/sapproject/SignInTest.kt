package com.example.sapproject

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sapproject.activities.MainActivity
import com.example.sapproject.activities.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class SignInTest {


    @get:Rule
    var activityRule = ActivityScenarioRule(SignInActivity::class.java)

    @Test
    fun signInTest()
    {
        val email = "shane@email.com"
        val password = "123456"
        val confPassword = "123456"

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener() { task ->
            assert(task.isSuccessful)

        }
    }

}