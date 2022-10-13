package com.etcmobileapps.ibanbankaccountanddigitalaccount.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.etcmobileapps.ibanbankaccountanddigitalaccount.adapter.BankAdapter
import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.FragmentBankAccountBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.view.BankAccountViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BankAccountFragment : Fragment() {
    private lateinit var bindingBank: FragmentBankAccountBinding
    private lateinit var viewModel: BankAccountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[BankAccountViewModel::class.java]

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


      fun setupRecylerView() {

          CoroutineScope(Dispatchers.IO).launch {
              var data =  viewModel.getAllIbans()
              Log.d("data:",data.toString())
              bindingBank.bankRecylerView.layoutManager = LinearLayoutManager(requireContext())
              bindingBank.bankRecylerView.adapter = data?.let { BankAdapter(it,requireContext()) }
          }
      }
}



