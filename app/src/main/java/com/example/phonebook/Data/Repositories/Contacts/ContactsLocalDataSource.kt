package com.example.phonebook.Data.Repositories.Contacts

import com.example.phonebook.Data.Database.ContactDao
import com.example.phonebook.Data.Mappers.EntityContactMapper
import com.example.phonebook.Domain.Contact
import com.example.phonebook.Domain.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactsLocalDataSource(
    dao: ContactDao,
    mapper: EntityContactMapper,
) : LocalDataSource {

    override fun getSingleEntityFromDb() {

    }

    override fun insertEntityInDb() {
        TODO("Not yet implemented")
    }

    override fun getAllEntitiesFromDb() {
        TODO("Not yet implemented")
    }


}