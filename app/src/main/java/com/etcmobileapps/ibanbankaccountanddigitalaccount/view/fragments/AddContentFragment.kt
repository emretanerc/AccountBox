package com.etcmobileapps.ibanbankaccountanddigitalaccount.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.adapter.IconAdapter

import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.FragmentAddContentBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Account
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban
import com.etcmobileapps.ibanbankaccountanddigitalaccount.viewmodels.AddContentViewModel


class AddContentFragment : Fragment() {
    private lateinit var bindingContent: FragmentAddContentBinding
    private lateinit var viewModel: AddContentViewModel

    var adapter: IconAdapter? = null
     var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[AddContentViewModel::class.java]
        viewModel.initDatabase()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         bindingContent = FragmentAddContentBinding.inflate(inflater, container, false)
         navController = Navigation.findNavController(requireActivity(), R.id.fragmentView)





        initOnClicks()

        return bindingContent.root
    }



    private fun initOnClicks() {

        // EditText - Digital
        val websiteNameTv =  bindingContent.websiteName
        val usernameTv =  bindingContent.username
        val passwordTv =  bindingContent.password

        // EditText - Bank Account
        val bankNameTv =  bindingContent.bankName
        val ibanNumberTv =  bindingContent.ibanNumber
        val currencyTv =  bindingContent.currency

        // Checkbox
        val bankCheckBox =  bindingContent.bankCheckBox
        val accountCheckBox =  bindingContent.accountCheckBox

        // Button
        val confirmButtonDigital =  bindingContent.confirmButtonDigital
        val confirmButtonAccount =  bindingContent.confirmButtonAccount


        confirmButtonDigital.setOnClickListener {
            viewModel.insertAccountData(Account(
                0,
                "Default",
                websiteNameTv.text.toString(),
                usernameTv.text.toString(),
                passwordTv.text.toString(),
            ))
            navController?.navigate(R.id.digitalAccountFragment)
            Toast.makeText(requireContext(), R.string.succesfull, Toast.LENGTH_SHORT).show()
        }
        confirmButtonAccount.setOnClickListener {
              viewModel.insertIbanData(Iban(
                0,
                bankNameTv.text.toString(),
                ibanNumberTv.text.toString(),
                currencyTv.text.toString()))
            navController?.navigate(R.id.bankAccountFragment)
            Toast.makeText(requireContext(), R.string.succesfull, Toast.LENGTH_SHORT).show()
        }

        bankCheckBox.setOnClickListener {
            bindingContent.informationTv.visibility = View.VISIBLE
            bindingContent.accountCheckBox.isChecked = false
            bindingContent.bankCheckBox.isChecked = true
            bindingContent.bankLayout.visibility = View.VISIBLE
            bindingContent.digitalLayout.visibility = View.GONE
        }
        accountCheckBox.setOnClickListener {
            bindingContent.informationTv.visibility = View.VISIBLE
            bindingContent.bankLayout.visibility = View.GONE
            bindingContent.digitalLayout.visibility = View.VISIBLE
            bindingContent.bankCheckBox.isChecked = false
            bindingContent.accountCheckBox.isChecked = true
            setupLogos()
        }
    }

    private fun setupLogos() {
     var  data =  viewModel.createLogos()
        bindingContent.digitalRecylerview.adapter = adapter
        adapter?.notifyDataSetChanged()
        //bindingContent.digitalRecylerview.layoutManager = LinearLayoutManager(requireActivity().applicationContext)
        bindingContent.digitalRecylerview.layoutManager = GridLayoutManager(context, 4)
        bindingContent.digitalRecylerview.adapter = data?.let { IconAdapter(it,requireContext()) }
    }



}