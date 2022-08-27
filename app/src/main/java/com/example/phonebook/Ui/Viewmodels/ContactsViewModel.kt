package com.example.phonebook.Ui.Viewmodels

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.Domain.Usecases.GetContactUseCase
import com.example.phonebook.Domain.Usecases.SaveContactUseCase
import com.example.phonebook.PhoneBookApplications
import com.example.phonebook.Ui.Model.PhonebookUiState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.schedulers.Schedulers

class ContactsViewModel(
    private val getContactUseCase: GetContactUseCase,
    private val saveContactUseCase: SaveContactUseCase,
) : ViewModel() {

    private val _uiState: MutableLiveData<PhonebookUiState> = MutableLiveData<PhonebookUiState>()
    val uiState: LiveData<PhonebookUiState> = _uiState

    fun getContactByNumber(number: String) {
        getContactUseCase.execute(number)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _uiState.postValue(
                    PhonebookUiState(
                        it.name,
                        it.phoneNumber,
                    )
                )
            }
    }

    fun saveContact(contact: Contact) {
        saveContactUseCase.execute(contact)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

}