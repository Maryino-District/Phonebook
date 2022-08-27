package com.example.phonebook.Data.Repositories.Contacts

import android.app.Application
import android.content.Context
import androidx.room.PrimaryKey
import com.example.phonebook.Data.Database.ContactDao
import com.example.phonebook.Data.Database.ContactDatabase
import com.example.phonebook.Data.Entity.ContactTableModel
import com.example.phonebook.Data.Mappers.EntityContactMapper
import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.PhoneBookApplications
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

class ContactsLocalDataSource(
) : LocalDataSource {

 //   private val context = PhoneBookApplications.getInstance().applicationContext
    private val db = ContactDatabase.get()
    private var dao: ContactDao = db!!.contactDao()

    override fun getSingleEntityFromDb(primaryKey: String) : Maybe<ContactTableModel> {
        return dao.getContact(primaryKey)
    }

    override fun insertEntityInDb(contact: ContactTableModel): Completable {
        return dao.insertContact(contact)
    }



}