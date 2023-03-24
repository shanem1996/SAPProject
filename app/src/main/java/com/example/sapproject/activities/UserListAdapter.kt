package com.example.sapproject.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.sapproject.R
import com.example.sapproject.activities.models.User
import com.google.android.material.snackbar.Snackbar

class UserListAdapter(context: Context, users: List<User>) :
    ArrayAdapter<User>(context, 0, users) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        }

        val currentUser = getItem(position)
        val nameTextView = listItemView!!.findViewById<TextView>(R.id.tvName)
        nameTextView.text = currentUser!!.name
        val usernameTextView = listItemView.findViewById<TextView>(R.id.tvUsername)
        usernameTextView.text = currentUser.username

        listItemView.setOnClickListener {
            Snackbar.make(parent, "Success: ${currentUser.name}", Snackbar.LENGTH_LONG).show()
        }

        return listItemView

    }
    }