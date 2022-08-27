package com.example.phonebook.Data.Repositories.Contacts

import android.content.Context
import com.example.phonebook.Data.Entity.ContactTableModel
import com.example.phonebook.Data.Mappers.EntityContactMapper
import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.Domain.Repositories.ContactRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

class ContactRepository(
    private val localDataSource: LocalDataSource = ContactsLocalDataSource(),
    private val mapper: EntityContactMapper = EntityContactMapper()
) : ContactRepository {

    override fun insertContact(contact: Contact): Completable {
        return localDataSource.insertEntityInDb(mapper.toContactTableModel(contact))
    }

    override fun getContact(number: String): Maybe<Contact> {
        return localDataSource.getSingleEntityFromDb(number)
            .map { mapper.toDomainContactModel(it) }
    }

}