package com.etcmobileapps.ibanbankaccountanddigitalaccount.view.ui.bankaccount

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.data.Db
import com.etcmobileapps.ibanbankaccountanddigitalaccount.data.Iban


class BankAccountViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db


    fun initDatabase() {
        database = Db.getDatabase(getApplication())!!
    }



       fun getAllIbans(): List<Iban>? {
        var data = emptyList<Iban>()

                 data = database.getManagerDao().getAllIbans()
                Log.d("data:",data.toString())

        return data
    }



}





