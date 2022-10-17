package com.etcmobileapps.ibanbankaccountanddigitalaccount.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.FragmentSettingsBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.viewmodels.SettingsViewModel


class SettingsFragment : Fragment()  {
    private lateinit var bindingSettings: FragmentSettingsBinding
    private lateinit var viewModel: SettingsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]

    }

    override  fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingSettings = FragmentSettingsBinding.inflate(inflater, container, false)



        return bindingSettings.root

    }







}



