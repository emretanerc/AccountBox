package com.etcmobileapps.ibanbankaccountanddigitalaccount.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey (autoGenerate = true) val id:Int,
    @ColumnInfo(name = "name") val application: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "password") val password: String?
)