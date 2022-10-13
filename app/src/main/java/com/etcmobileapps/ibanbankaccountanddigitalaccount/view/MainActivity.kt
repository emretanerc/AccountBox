package com.etcmobileapps.ibanbankaccountanddigitalaccount.view



import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.ActivityMainBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.view.fragments.BankAccountFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


private lateinit var bindingMain : ActivityMainBinding

class MainActivity : AppCompatActivity() {

     private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]




        setupBottomNavigation()
        setupTopBar()


    }


    private fun setupTopBar() {
         val navController: NavController = Navigation.findNavController(this, R.id.fragmentView)

        bindingMain.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                   navController.navigate(R.id.addContentFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupBottomNavigation() {

         val navController: NavController = Navigation.findNavController(this, R.id.fragmentView)

        bindingMain.navView.setOnItemSelectedListener { item ->
            var currentFragment = navController.currentDestination!!.id

            when(item.itemId) {
                R.id.page_1 -> {

                    if(currentFragment != R.id.bankAccountFragment){
                        navController.navigate(R.id.bankAccountFragment)
                    }

                    true
                }
                R.id.page_2 -> {
                    if(currentFragment != R.id.digitalAccountFragment){
                        navController.navigate(R.id.digitalAccountFragment)
                    }

                    true
                }

                else -> false
            }
        }
    }
}


