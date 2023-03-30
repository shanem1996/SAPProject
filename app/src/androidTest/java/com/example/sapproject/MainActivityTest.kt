package com.example.sapproject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sapproject.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun btnSignInTest() {
        onView(withId(R.id.btnSignIn)).perform(click())
        onView(withId(R.id.btnSignIn)).check(matches(isDisplayed()))
        onView(withId(R.id.tfEmail)).check(matches(isDisplayed()))
    }

    @Test
    fun btnSignUpTest() {
        onView(withId(R.id.btnSignUp)).perform(click())
        onView(withId(R.id.btnSignUp)).check(matches(isDisplayed()))
        onView(withId(R.id.tfEmail)).check(matches(isDisplayed()))
    }


}