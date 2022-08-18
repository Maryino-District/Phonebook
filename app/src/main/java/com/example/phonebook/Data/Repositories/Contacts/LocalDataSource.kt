package com.example.phonebook.Data.Repositories.Contacts

interface LocalDataSource {
    fun getSingleEntityFromDb()

    fun insertEntityInDb()

    fun getAllEntitiesFromDb()
}