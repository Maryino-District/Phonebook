package com.example.phonebook.Domain.Usecases

import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.Domain.Repositories.ContactRepository
import io.reactivex.rxjava3.core.Maybe

class GetContactUseCase(private val contactRepository: ContactRepository) {

    fun execute(number: String): Maybe<Contact> {
        return contactRepository.getContact(number)
    }
}