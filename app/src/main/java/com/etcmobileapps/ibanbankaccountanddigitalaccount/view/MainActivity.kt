package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R

import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.ActivityMainBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.view.fragments.BankAccountFragment
import com.etcmobileapps.ibanbankaccountanddigitalaccount.view.fragments.DigitalAccountFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.google.android.material.floatingactionbutton.FloatingActionButton


private lateinit var bindingMain : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appName: EditText
    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var addButton: FloatingActionButton
    var currentFragment:Fragment = BankAccountFragment()
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.initDatase()
        init()


    }

    fun init() {

        val navController: NavController = Navigation.findNavController(this, R.id.fragmentView)

        bindingMain.navView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    if (currentFragment == BankAccountFragment()) {
                        false
                      } else {
                        navController.navigate(R.id.action_digitalAccountFragment_to_bankAccountFragment)
                        currentFragment = BankAccountFragment()

                        true
                    }
                    true
                }
                R.id.page_2 -> {
                    if (currentFragment == DigitalAccountFragment()) {
                        false
                    } else {
                        navController.navigate(R.id.action_bankAccountFragment_to_digitalAccountFragment)
                        currentFragment = DigitalAccountFragment()
                        true
                    }

                }
                else -> false
            }
        }
    }
}


