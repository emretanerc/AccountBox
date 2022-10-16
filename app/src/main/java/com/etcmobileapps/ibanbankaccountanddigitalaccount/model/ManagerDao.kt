package com.etcmobileapps.ibanbankaccountanddigitalaccount.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

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

    @Query("DELETE FROM accounts WHERE uid = :id")
    fun deleteAccountById(id: Long)

    @Query("DELETE FROM ibans WHERE uid = :id")
    fun deleteIbanById(id: Long)

}

