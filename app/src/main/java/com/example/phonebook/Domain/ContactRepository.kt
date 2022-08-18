package com.example.phonebook.Domain

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun insertContact(contact: Contact)

    fun getContact(name: String)

    fun getAllContacts()
}