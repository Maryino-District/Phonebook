package com.example.phonebook.Domain.Usecases

import android.content.Context
import com.example.phonebook.Data.Repositories.Contacts.ContactRepository
import com.example.phonebook.Domain.Entity.Contact
import io.reactivex.rxjava3.core.Maybe

class GetContactUseCase(
    private val contactRepository: ContactRepository = ContactRepository()
) {


    fun execute(number: String): Maybe<Contact> {
        return contactRepository.getContact(number)
    }
}