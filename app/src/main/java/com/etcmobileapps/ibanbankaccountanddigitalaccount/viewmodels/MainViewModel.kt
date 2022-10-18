package com.etcmobileapps.ibanbankaccountanddigitalaccount.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.data.Db


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db





    fun initDatase() {
        database = Db.getDatabase(getApplication())!!
    }


     fun add(appNameValue:String,userNameValue:String,passwordValue:String) {
        if(appNameValue != "" || userNameValue != "" || passwordValue != ""){

            Toast.makeText(getApplication(), "Eklendi!", Toast.LENGTH_LONG).show()
            println("eklendi")
        } else {
            Toast.makeText(getApplication(), "Boş alan mevcut!", Toast.LENGTH_LONG).show()
        }
    }
}





