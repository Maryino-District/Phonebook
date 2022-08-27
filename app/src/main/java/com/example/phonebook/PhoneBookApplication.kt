package com.example.phonebook

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.phonebook.Data.Database.ContactDatabase


class PhoneBookApplications : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
    }
@SuppressLint("StaticFieldLeak")
companion object {
    lateinit var context: Context
}
}