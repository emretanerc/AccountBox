package com.etcmobileapps.accountbox.view.ui.digitalaccount

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.etcmobileapps.accountbox.view.adapter.AccountAdapter
import com.etcmobileapps.accountbox.databinding.FragmentBankAccountBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DigitalAccountFragment : Fragment()  {
    private lateinit var bindingBank: FragmentBankAccountBinding
    private lateinit var viewModel: DigitalAccountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DigitalAccountViewModel::class.java]

    }

    override  fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingBank = FragmentBankAccountBinding.inflate(inflater, container, false)

        viewModel.initDatabase()
        setupRecylerView()
        return bindingBank.root

    }


    private fun setupRecylerView() {
        CoroutineScope(Dispatchers.Main).launch {
            var data =  viewModel.getAllAccounts()
            Log.d("data:",data.toString())
            bindingBank.bankRecylerView.adapter = AccountAdapter(data)
            bindingBank.bankRecylerView.layoutManager = LinearLayoutManager(requireActivity().applicationContext)
        }
    }





}



