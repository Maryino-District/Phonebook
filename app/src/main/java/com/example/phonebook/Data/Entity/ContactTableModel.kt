package com.example.phonebook.Data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class ContactTableModel(
    @PrimaryKey
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String,

    @ColumnInfo(name = "name")
    var name: String,
)