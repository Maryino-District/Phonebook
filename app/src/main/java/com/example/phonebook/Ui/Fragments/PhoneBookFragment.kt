package com.example.phonebook.Ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.phonebook.Data.Mappers.EntityContactMapper
import com.example.phonebook.Data.Repositories.Contacts.ContactRepository
import com.example.phonebook.Data.Repositories.Contacts.ContactsLocalDataSource
import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.databinding.FragmentPhoneBookBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PhoneBook.newInstance] factory method to
 * create an instance of this fragment.
 */
class PhoneBook : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var binding: FragmentPhoneBookBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneBookBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnSaveContact?.setOnClickListener {
            binding?.run {
                val textPhone = editEnterPhone.text
                val textName = editEnterName.text
                val contactRepository = ContactRepository(ContactsLocalDataSource(
                    EntityContactMapper(),
                    requireContext()
                ))
                contactRepository.insertContact(Contact(12, ContactInformation("Name", "892222")))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Toast.makeText(requireContext(), "ddd", Toast.LENGTH_LONG).show()
                    }


            }
        }
        binding?.btnReadLogin?.setOnClickListener {
            Toast.makeText(requireContext(),"ddd", Toast.LENGTH_LONG).show()
            ContactRepository(
                ContactsLocalDataSource(
                EntityContactMapper(),
                requireContext()
            ))
                .getContact(Contact(12, ContactInformation("Name", "892222")))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    binding?.tvNameResult?.text = it.name
                }
        }

    }

    override fun onStop() {
        super.onStop()
        binding = null
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PhoneBook.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            PhoneBook().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}