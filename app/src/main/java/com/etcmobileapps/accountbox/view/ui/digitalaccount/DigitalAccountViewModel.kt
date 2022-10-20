package com.etcmobileapps.accountbox.view.ui.digitalaccount

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.etcmobileapps.accountbox.data.Account
import com.etcmobileapps.accountbox.data.Db


class DigitalAccountViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db
    lateinit var data : MutableList<Account>


    fun initDatabase() {
        database = Room.databaseBuilder(
            getApplication(),
            Db::class.java, "database.db"
        ).allowMainThreadQueries().build()

    }



    fun getAllAccounts(): MutableList<Account> {
        data = database.getManagerDao().getAllAccounts()
        Log.d("data:",data.toString())
        return data
    }






}





