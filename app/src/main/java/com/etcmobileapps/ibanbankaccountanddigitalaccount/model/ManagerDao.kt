package com.etcmobileapps.ibanbankaccountanddigitalaccount.model

import androidx.room.*
import com.etcmobileapps.ibanbankaccountanddigitalaccount.adapter.AccountAdapter

@Dao

interface ManagerDao {
    @Insert
    fun addAccount(account: Account): Long

    @Insert
    fun addIban(iban: Iban): Long

    @Query("SELECT * FROM ibans")
    fun getAllIbans(): List<Iban>

    @Query("SELECT * FROM accounts")
    fun getAllAccounts(): List<Account>

}

