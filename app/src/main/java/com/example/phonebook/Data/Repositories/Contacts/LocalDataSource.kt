package com.example.phonebook.Data.Repositories.Contacts
import androidx.room.PrimaryKey
import com.example.phonebook.Data.Entity.ContactTableModel
import com.example.phonebook.Domain.Entity.Contact
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

interface LocalDataSource {

    fun getSingleEntityFromDb(primaryKey: String): Maybe<ContactTableModel>

    fun insertEntityInDb(contact: ContactTableModel): Completable
}