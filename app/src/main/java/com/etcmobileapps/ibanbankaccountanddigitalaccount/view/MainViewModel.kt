package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Account
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Db
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db





    fun initDatase() {
        database = Db.getDatabase(getApplication())!!
    }


     fun add(appNameValue:String,userNameValue:String,passwordValue:String) {
        if(appNameValue != "" || userNameValue != "" || passwordValue != ""){
            CoroutineScope(Dispatchers.IO).launch {
                database.getAccountDao().addAccount(Account(1,appNameValue,userNameValue,passwordValue))
            }
            Toast.makeText(getApplication(), "Eklendi!", Toast.LENGTH_LONG).show()
            println("eklendi")
        } else {
            Toast.makeText(getApplication(), "Boş alan mevcut!", Toast.LENGTH_LONG).show()
        }
    }
}





