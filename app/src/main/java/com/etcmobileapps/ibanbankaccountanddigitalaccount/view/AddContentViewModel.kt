package com.etcmobileapps.ibanbankaccountanddigitalaccount.view



import android.app.Application
import android.bluetooth.BluetoothAdapter.ERROR
import android.database.sqlite.SQLiteException
import android.util.Log
import android.util.Log.DEBUG


import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Db
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddContentViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db


    fun initDatabase() {
        database = Db.getDatabase(getApplication())!!
    }

    fun insertData(bankName:String,ibanNumber:String): String {
        var result: Long? =null
        CoroutineScope(Dispatchers.IO).launch {
            try {
              val id = database.getManagerDao().addIban(Iban( 0,"Garanti", "TR45454545", "TL"))
                if (id != null) {
                   result=id
                    Log.d("AddContentView:", "Succesfull instert." )
                }
            } catch (e: SQLiteException) {
                Log.d("AddContentView Insert Data Exception: ",e.toString())
            }
        }

        return result.toString()

    }


}





