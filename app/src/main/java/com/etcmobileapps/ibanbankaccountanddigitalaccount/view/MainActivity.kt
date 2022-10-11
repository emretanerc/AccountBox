package com.etcmobileapps.ibanbankaccountanddigitalaccount.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast


import androidx.lifecycle.ViewModelProvider

import com.etcmobileapps.ibanbankaccountanddigitalaccount.databinding.ActivityMainBinding

import com.google.android.material.floatingactionbutton.FloatingActionButton


private lateinit var bindingMain : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appName: EditText
    private lateinit var userName: EditText
    private lateinit var password: EditText

    private lateinit var addButton: FloatingActionButton
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.initDatase()
        init()


    }

    fun init() {


    }
}


