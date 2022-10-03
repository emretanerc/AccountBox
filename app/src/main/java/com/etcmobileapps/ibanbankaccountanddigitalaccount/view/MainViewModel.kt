package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.ActivityMainBinding
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Db
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar


class MainViewModel(application: Application) : AndroidViewModel(application) {




    val context = getApplication<Application>().applicationContext!!
    val database : Db = Db.getDatabase(context)!!

    fun refreshData(){

    }

    fun add() {

    }
}

