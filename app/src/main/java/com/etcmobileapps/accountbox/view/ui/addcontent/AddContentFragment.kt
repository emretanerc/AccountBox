package com.etcmobileapps.accountbox.view.ui.addcontent

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
import com.etcmobileapps.accountbox.R
import com.etcmobileapps.accountbox.view.adapter.IconAdapter

import com.etcmobileapps.accountbox.databinding.FragmentAddContentBinding
import com.etcmobileapps.accountbox.data.Account
import com.etcmobileapps.accountbox.data.Iban


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

        bindingContent.confirmButtonDigital.setOnClickListener {
            viewModel.insertAccountData(Account(
                0,
                "Default",
                bindingContent.websiteName.text.toString(),
                bindingContent.username.text.toString(),
                bindingContent.password.text.toString(),
            ))
            navController?.navigate(R.id.digitalAccountFragment)
            Toast.makeText(requireContext(), R.string.succesfull, Toast.LENGTH_SHORT).show()
        }
        bindingContent.confirmButtonAccount.setOnClickListener {
              viewModel.insertIbanData(Iban(
                0,
                bindingContent.bankName.text.toString(),
                bindingContent.ibanNumber.text.toString(),
                bindingContent.currency.text.toString()))
            navController?.navigate(R.id.bankAccountFragment)
            Toast.makeText(requireContext(), R.string.succesfull, Toast.LENGTH_SHORT).show()
        }

        bindingContent.bankCheckBox.setOnClickListener {
            bindingContent.informationTv.visibility = View.VISIBLE
            bindingContent.accountCheckBox.isChecked = false
            bindingContent.bankCheckBox.isChecked = true
            bindingContent.bankLayout.visibility = View.VISIBLE
            bindingContent.digitalLayout.visibility = View.GONE
        }
        bindingContent.accountCheckBox.setOnClickListener {
            bindingContent.informationTv.visibility = View.VISIBLE
            bindingContent.bankLayout.visibility = View.GONE
            bindingContent.digitalLayout.visibility = View.VISIBLE
            bindingContent.bankCheckBox.isChecked = false
            bindingContent.accountCheckBox.isChecked = true
            setupLogos()
        }
    }

    private fun setupLogos() {
     val  data =  viewModel.getLogos()
        bindingContent.digitalRecylerview.adapter = adapter
        adapter?.notifyDataSetChanged()
        //bindingContent.digitalRecylerview.layoutManager = LinearLayoutManager(requireActivity().applicationContext)
        bindingContent.digitalRecylerview.layoutManager = GridLayoutManager(context, 4)
        bindingContent.digitalRecylerview.adapter = data?.let { IconAdapter(it,requireContext()) }
    }



}