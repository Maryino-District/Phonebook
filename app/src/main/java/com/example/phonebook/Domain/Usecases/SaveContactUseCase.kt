package com.example.phonebook.Domain.Usecases

import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.Domain.Repositories.ContactRepository
import io.reactivex.rxjava3.core.Completable

class SaveContactUseCase(private val contactRepository: ContactRepository) {

    fun execute(contact: Contact): Completable {
        return contactRepository.insertContact(contact)
    }
}