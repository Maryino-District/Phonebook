package com.example.phonebook.Data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class ContactTableModel(
    @ColumnInfo(name = "name")
    var name: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String,
)