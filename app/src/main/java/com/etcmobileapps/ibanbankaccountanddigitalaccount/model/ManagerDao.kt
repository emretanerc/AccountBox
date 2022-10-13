package com.etcmobileapps.ibanbankaccountanddigitalaccount.model

import androidx.room.*

@Dao

interface ManagerDao {
    @Insert
    fun addAccount(account: Account)

    @Insert
    fun addIban(iban: Iban): Long

    @Query("SELECT * FROM ibans")
    fun getAllIbans(): List<Iban>

}

