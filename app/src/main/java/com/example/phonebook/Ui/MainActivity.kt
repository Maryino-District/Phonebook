package com.example.phonebook.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.example.phonebook.R
import com.example.phonebook.Ui.Fragments.PhoneBook
import com.example.phonebook.databinding.FragmentPhoneBookBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, PhoneBook.newInstance())
                .commit()
        }
    }
}