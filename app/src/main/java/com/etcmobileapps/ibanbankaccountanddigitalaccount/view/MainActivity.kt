package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.ActivityMainBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Account
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Db
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


private lateinit var bindingMain : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appName: EditText
    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var database: Db
    private lateinit var button:FloatingActionButton
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.refreshData()


        database = Db.getDatabase(this)!!

        init()

    }


    fun init() {
        appName = findViewById(R.id.appNameEditText)
        userName = findViewById(R.id.usernameEditText)
        password = findViewById(R.id.passwordEditText)
        button = findViewById(R.id.btn_add)

        button.setOnClickListener {
            add()
        }
    }

    private fun add(){
        val appNameValue = appName.text.toString()
        val userNameValue = userName.text.toString()
        val passwordValue = password.text.toString()
        if(appNameValue != "" || userNameValue != "" || passwordValue != ""){

            CoroutineScope(Dispatchers.IO).launch {
                database.getAccountDao().addAccount(Account(1,appNameValue,userNameValue,passwordValue))
            }
            Toast.makeText(this, "Eklendi.", Toast.LENGTH_LONG).show()
       //     val intent = Intent(this, ShowBooksActivity::class.java)
      //      startActivity(intent)
      //      finish()
        }
    }
}