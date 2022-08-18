package com.example.phonebook.Data.Repositories.Contacts

import com.example.phonebook.Domain.Contact
import com.example.phonebook.Domain.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactRepository(
    private val localDataSource: LocalDataSource
) : ContactRepository {
    override suspend fun insertContact(contact: Contact) {
        localDataSource.insertEntityInDb()
    }

    override fun getContact(name: String) {
        localDataSource.getSingleEntityFromDb()
    }

    override fun getAllContacts() {
        localDataSource.getAllEntitiesFromDb()
    }
}