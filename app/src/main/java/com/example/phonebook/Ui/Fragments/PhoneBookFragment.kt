package com.example.phonebook.Ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.phonebook.Data.Database.ContactDao
import com.example.phonebook.Data.Database.ContactDatabase
import com.example.phonebook.Data.Entity.ContactTableModel
import com.example.phonebook.Domain.Entity.Contact
import com.example.phonebook.PhoneBookApplications
import com.example.phonebook.Ui.Viewmodels.ContactsViewModel
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
    val contactViewModel: ContactsViewModel by viewModels()
    private  lateinit var db: ContactDatabase
    private lateinit var dao: ContactDao
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
        db = ContactDatabase.getInstance(requireContext())
        dao = db.contactDao()


        binding = FragmentPhoneBookBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding?.btnSaveContact?.setOnClickListener {
            binding?.run {
                val textPhone = editEnterPhone.text
                val textName = editEnterName.text

                 contactViewModel.saveContact(Contact(textName.toString(), textPhone.toString()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({Toast.makeText(requireContext(), "Saved", Toast.LENGTH_LONG).show()},
                        {Toast.makeText(requireContext(), "blya", Toast.LENGTH_LONG).show()})
            }

        }
        binding?.btnReadLogin?.setOnClickListener {
           contactViewModel.getContactByNumber(binding!!.editEnterPhone.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(context,"YAHOO", Toast.LENGTH_LONG)
                    binding!!.run {
                        tvNameResult.text = it.name
                        tvPhoneResult.text = it.phoneNumber
                    }
                },{Toast.makeText(requireContext(), "hz", Toast.LENGTH_LONG).show()})

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