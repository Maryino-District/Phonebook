package com.example.phonebook.Data.Mappers

import com.example.phonebook.Domain.Contact

class EntityContactMapper {
    fun toContactTableModel(contact: Contact) {
        return ContactTableModel(
            name = contact.contactInf.name,
            phoneNumber = contact.contactInf.phoneNumber,
            contactId = contact.id,
        )
    }
}