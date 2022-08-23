package com.example.phonebook.Data.Mappers

import com.example.phonebook.Data.Entity.ContactTableModel
import com.example.phonebook.Domain.Entity.Contact

class EntityContactMapper {
    fun toContactTableModel(contact: Contact) : ContactTableModel {
        return ContactTableModel(
            name = contact.name,
            phoneNumber = contact.phoneNumber,
        )
    }

    fun toDomainContactModel(contact: ContactTableModel) : Contact {
        return Contact(
            name = contact.name,
            phoneNumber = contact.phoneNumber,
        )
    }
}