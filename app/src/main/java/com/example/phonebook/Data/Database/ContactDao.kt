package com.example.phonebook.Data.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.phonebook.Data.Entity.ContactTableModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: ContactTableModel): Completable

    @Query("SELECT * FROM Contact WHERE phoneNumber =:phone")
    fun getContact(phone: String): Maybe<ContactTableModel>

    @Query("SELECT * FROM Contact")
    fun getAllContacts() : List<ContactTableModel>

}