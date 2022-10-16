package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import android.app.Application
import android.database.sqlite.SQLiteException
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Account
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Db
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.ManagerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DigitalAccountViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db
    lateinit var data : List<Account>


    fun initDatabase() {
        database = Room.databaseBuilder(
            getApplication(),
            Db::class.java, "database.db"
        ).allowMainThreadQueries().build()

    }



    fun getAllAccounts(): MutableList<Account> {
        data = database.getManagerDao().getAllAccounts()
        Log.d("data:",data.toString())
        return data as MutableList<Account>
    }






}





