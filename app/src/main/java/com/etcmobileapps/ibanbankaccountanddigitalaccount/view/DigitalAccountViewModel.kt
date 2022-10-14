package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import android.app.Application
import android.database.sqlite.SQLiteException
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Account
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Db
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DigitalAccountViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db


    fun initDatabase() {
        database = Db.getDatabase(getApplication())!!
    }



    fun getAllAccounts(): List<Account>? {
        var data = emptyList<Account>()

        data = database.getManagerDao().getAllAccounts()
        Log.d("data:",data.toString())

        return data
    }



}





