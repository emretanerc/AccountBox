package com.etcmobileapps.ibanbankaccountanddigitalaccount.model

import androidx.room.*

@Dao

interface AccountDao {
    @Insert
    fun addAccount(account: Account)


}

