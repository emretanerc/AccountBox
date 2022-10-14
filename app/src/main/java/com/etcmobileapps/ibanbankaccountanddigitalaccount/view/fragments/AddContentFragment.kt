package com.etcmobileapps.ibanbankaccountanddigitalaccount.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.ActivityMainBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.FragmentAddContentBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.view.AddContentViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.view.BankAccountViewModel
import com.google.android.material.snackbar.Snackbar


class AddContentFragment : Fragment() {
    private lateinit var bindingContent: FragmentAddContentBinding
    private lateinit var viewModel: AddContentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[AddContentViewModel::class.java]
        viewModel.initDatabase()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingContent = FragmentAddContentBinding.inflate(inflater, container, false)


        bindingContent.confirmButtonDigital.setOnClickListener {
            var message = viewModel.insertAccountData("s", "s",)
            if (message != null) {
                Toast.makeText(requireActivity(), R.string.succesfull, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), R.string.succesfull, Toast.LENGTH_SHORT).show()
            }
        }
        return bindingContent.root
    }
}