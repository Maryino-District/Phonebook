package com.example.phonebook.Data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.phonebook.Data.Entity.ContactTableModel


@Database(entities = [ContactTableModel::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: ContactDatabase? = null

        fun initialize(context: Context) : ContactDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext, ContactDatabase::class.java, "CONTACT_DATABASE")
                        .build()
                }
            }
            return INSTANCE!!
        }

        fun get() : ContactDatabase? {
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}