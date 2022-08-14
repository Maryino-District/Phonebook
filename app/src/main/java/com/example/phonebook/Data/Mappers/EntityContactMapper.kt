package com.example.phonebook.Data.Mappers

import com.example.phonebook.Data.Entity.ContactTableModel
import com.example.phonebook.Domain.Contact
import com.example.phonebook.Domain.ContactInformation

class EntityContactMapper {
    fun toContactTableModel(contact: Contact) : ContactTableModel {
        return ContactTableModel(
            name = contact.contactInf.name,
            phoneNumber = contact.contactInf.phoneNumber,
            contactId = contact.id,
        )
    }

    fun toDomainContactModel(contact: ContactTableModel) : Contact {
        return Contact(
            id = contact.contactId!!,
            ContactInformation(
                name = contact.name,
                phoneNumber = contact.phoneNumber,
            )
        )
    }
}