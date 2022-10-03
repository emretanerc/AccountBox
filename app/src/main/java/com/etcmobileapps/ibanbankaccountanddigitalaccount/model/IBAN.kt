package com.etcmobileapps.ibanbankaccountanddigitalaccount.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ibans")
data class IBAN(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "bankName") val application: String?,
    @ColumnInfo(name = "IBAN") val username: String?,
    @ColumnInfo(name = "currency") val password: String?
)