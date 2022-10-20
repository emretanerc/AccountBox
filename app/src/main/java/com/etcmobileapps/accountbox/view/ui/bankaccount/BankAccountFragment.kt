package com.etcmobileapps.accountbox.view.ui.bankaccount

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.etcmobileapps.accountbox.data.Iban
import com.etcmobileapps.accountbox.view.adapter.BankAdapter
import com.etcmobileapps.accountbox.databinding.FragmentBankAccountBinding

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
              var data:MutableList<Iban> =  viewModel.getAllIbans()
              Log.d("data:",data.toString())
              bindingBank.bankRecylerView.layoutManager = LinearLayoutManager(requireContext())
              bindingBank.bankRecylerView.adapter = BankAdapter(data)
      }
}



