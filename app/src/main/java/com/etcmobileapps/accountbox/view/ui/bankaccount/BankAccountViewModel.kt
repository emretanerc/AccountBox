package com.etcmobileapps.accountbox.view.ui.bankaccount

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.accountbox.data.Account
import com.etcmobileapps.accountbox.data.Db
import com.etcmobileapps.accountbox.data.Iban


class BankAccountViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db
    lateinit var data : MutableList<Iban>

    fun initDatabase() {
        database = Db.getDatabase(getApplication())!!
    }



       fun getAllIbans(): MutableList<Iban> {


            data = database.getManagerDao().getAllIbans()
                Log.d("data:",data.toString())

           return data
    }



}





