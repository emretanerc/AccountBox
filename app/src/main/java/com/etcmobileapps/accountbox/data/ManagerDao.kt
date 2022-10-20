package com.etcmobileapps.accountbox.data

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
    fun getAllIbans(): MutableList<Iban>

    @Query("SELECT * FROM accounts")
    fun getAllAccounts(): MutableList<Account>

    @Query("DELETE FROM accounts WHERE uid = :id")
    fun deleteAccountById(id: Int)

    @Query("DELETE FROM ibans WHERE uid = :id")
    fun deleteIbanById(id: Int)

}

