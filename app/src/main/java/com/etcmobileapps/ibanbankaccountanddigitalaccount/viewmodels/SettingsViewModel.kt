package com.etcmobileapps.ibanbankaccountanddigitalaccount.viewmodels



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


class SettingsViewModel(application: Application) : AndroidViewModel(application) {

}





