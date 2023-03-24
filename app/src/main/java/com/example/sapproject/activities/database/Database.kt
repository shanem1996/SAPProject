package com.example.sapproject.activities.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import com.example.sapproject.activities.models.Event
import com.example.sapproject.activities.models.User

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME = "database.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"

        const val EVENT_TABLE = "events"
        const val COLUMN_EVENT_NAME = "name"
        const val COLUMN_DATE = "date"
        const val COLUMN_DESC = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME TEXT, $COLUMN_USERNAME TEXT, $COLUMN_PASSWORD TEXT)"

        val createEventTable = "CREATE TABLE $EVENT_TABLE ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_EVENT_NAME TEXT, $COLUMN_DATE TEXT, $COLUMN_DESC TEXT)"
        db.execSQL(createEventTable)
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        db.execSQL("DROP TABLE IF EXISTS " + EVENT_TABLE)
        onCreate(db)



    }

    fun getEvents(): List<Event> {
        val events = mutableListOf<Event>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $EVENT_TABLE", null)
        try {
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                    val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))
                    val desc = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESC))
                    events.add(Event(name, date, desc))
                } while (cursor.moveToNext())
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error")
        } finally {
            cursor.close()
            db.close()
        }
        return events
    }

    fun getUsers(): List<User> {
        val users = mutableListOf<User>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        try {
            if(cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                    val username = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME))
                    users.add(User(name, username))
                } while (cursor.moveToNext())
            }
        } catch (e: java.lang.Exception) {
            Log.e(TAG, "Error")
        } finally {
            cursor.close()
            db.close()
        }
        return users

    }



}
