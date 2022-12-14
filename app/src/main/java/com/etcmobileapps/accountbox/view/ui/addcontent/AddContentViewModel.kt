package com.etcmobileapps.accountbox.view.ui.addcontent




import android.app.Application
import android.database.sqlite.SQLiteException
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.etcmobileapps.accountbox.R
import com.etcmobileapps.accountbox.data.Account
import com.etcmobileapps.accountbox.data.Db
import com.etcmobileapps.accountbox.data.Iban
import com.etcmobileapps.accountbox.data.IconModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddContentViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var database: Db

    fun getLogos(): ArrayList<IconModel> {
        val data: ArrayList<IconModel> = ArrayList()
        data.add(IconModel(R.drawable.facebooklogo, "Facebook"))
        data.add(IconModel(R.drawable.netlixlogo, "Netflix"))
        data.add(IconModel(R.drawable.spotifylogo, "Spotify"))
        data.add(IconModel(R.drawable.instagramlogo, "Instagram"))
        data.add(IconModel(R.drawable.amazon, "Amazon"))
        data.add(IconModel(R.drawable.twitter, "Twitter"))
        data.add(IconModel(R.drawable.yahoo, "Yahoo"))
        data.add(IconModel(R.drawable.reddit, "Reddit"))
        data.add(IconModel(R.drawable.youtube, "Youtube"))
        data.add(IconModel(R.drawable.other, "Other"))
        return data
    }


    fun initDatabase() {
        database = Db.getDatabase(getApplication())!!
    }

    fun insertAccountData(account: Account): String {
        var result: Long? =null
        CoroutineScope(Dispatchers.IO).launch {
            try {
              val id = database.getManagerDao().addAccount(account)
                result=id
                Log.d("AddContentView:", "Succesfull insert." )
            } catch (e: SQLiteException) {
                Log.d("AddContentView Insert Data Exception: ",e.toString())
            }
        }
        return result.toString()
    }

    fun insertIbanData(iban: Iban): String {
        var result: Long? =null
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val id = database.getManagerDao().addIban(iban)
                result=id
                Log.d("AddContentView:", "Succesfull insert." )
            } catch (e: SQLiteException) {
                Log.d("AddContentView Insert Data Exception: ",e.toString())
            }
        }
        return result.toString()
    }


}





