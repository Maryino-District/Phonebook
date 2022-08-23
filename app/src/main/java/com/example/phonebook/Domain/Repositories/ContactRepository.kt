package com.example.phonebook.Domain.Repositories

import com.example.phonebook.Data.Entity.ContactTableModel
import com.example.phonebook.Domain.Entity.Contact
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

interface ContactRepository {

    fun insertContact(contact: Contact): Completable

    fun getContact(number: String): Maybe<Contact>
}