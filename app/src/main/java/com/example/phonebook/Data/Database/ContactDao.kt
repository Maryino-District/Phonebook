package com.example.phonebook.Data.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.phonebook.Data.Entity.ContactTableModel

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: ContactTableModel)

    @Query("SELECT * FROM Contact WHERE name =:name")
    fun getContact(name: String) : ContactTableModel

    @Query("SELECT * FROM Contact")
    fun getAllContacts() : List<ContactTableModel>

}