package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import android.app.Application
import android.database.sqlite.SQLiteException
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Db
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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





