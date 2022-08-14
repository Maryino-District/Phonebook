package com.example.phonebook.Data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String,

    @PrimaryKey(autoGenerate = true)
    var contactId: Int? = null
)