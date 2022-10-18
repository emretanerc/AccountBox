package com.etcmobileapps.ibanbankaccountanddigitalaccount.view.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.ActivityMainBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.viewmodels.MainViewModel

private lateinit var bindingMain : ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private lateinit var viewModel: MainViewModel
    private var navController:NavController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        navController = findNavController(R.id.fragmentView)
        setupBottomNavigation()
        initOnClick()
    }

    fun initOnClick() {
        bindingMain.addView.setOnClickListener {
            navController?.navigate(R.id.addContentFragment)
        }

        bindingMain.settingView.setOnClickListener {
            navController?.navigate(R.id.settingsFragment)
        }
    }

    private fun setupBottomNavigation() {
        bindingMain.navView.setOnItemSelectedListener { item ->
            val currentFragment = navController?.currentDestination!!.id
            when(item.itemId) {
                R.id.page_1 -> {
                    if(currentFragment != R.id.digitalAccountFragment){
                        navController?.navigate(R.id.digitalAccountFragment)
                    }
                    true
                }
                R.id.page_2 -> {
                    if(currentFragment != R.id.bankAccountFragment){
                        navController?.navigate(R.id.bankAccountFragment)
                    }
                    true
                }
                else -> false
            }
        }
    }
}


