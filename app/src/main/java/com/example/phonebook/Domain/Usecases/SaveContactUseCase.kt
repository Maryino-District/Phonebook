package com.example.phonebook.Domain.Usecases

import android.content.Context
import com.example.phonebook.Data.Repositories.Contacts.ContactRepository
import com.example.phonebook.Domain.Entity.Contact
import io.reactivex.rxjava3.core.Completable


class SaveContactUseCase(
    private val contactRepository: ContactRepository = ContactRepository()
) {

    fun execute(contact: Contact): Completable {
        return contactRepository.insertContact(contact)
    }
}