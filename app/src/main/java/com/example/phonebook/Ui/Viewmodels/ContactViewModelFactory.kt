package com.example.phonebook.Ui.Viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.phonebook.Domain.Usecases.GetContactUseCase
import com.example.phonebook.Domain.Usecases.SaveContactUseCase

class ContactViewModelFactory(
    private val getContactUseCase: GetContactUseCase,
    private val saveContactUseCase: SaveContactUseCase,
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactsViewModel(
            getContactUseCase,
            saveContactUseCase
        ) as T
    }
}