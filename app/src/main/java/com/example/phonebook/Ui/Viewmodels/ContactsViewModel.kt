package com.example.phonebook.Ui.Viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.Domain.Usecases.GetContactUseCase
import com.example.phonebook.Domain.Usecases.SaveContactUseCase
import com.example.phonebook.PhoneBookApplications
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

class ContactsViewModel(

) : ViewModel() {

    private val getContactUseCase: GetContactUseCase = GetContactUseCase()
    private val saveContactUseCase: SaveContactUseCase = SaveContactUseCase()
    fun getContactByNumber(number: String): Maybe<Contact> {
        return getContactUseCase.execute(number)
    }

    fun saveContact(contact: Contact): Completable {
        return saveContactUseCase.execute(contact)
    }

}