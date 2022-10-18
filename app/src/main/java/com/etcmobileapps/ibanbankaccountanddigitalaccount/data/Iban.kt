package com.etcmobileapps.ibanbankaccountanddigitalaccount.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ibans")
data class Iban(
    @PrimaryKey (autoGenerate = true)
    val uid:Int=0,
    @ColumnInfo(name = "bankName") val bankName: String?,
    @ColumnInfo(name = "IBAN") val ibanNumber: String?,
    @ColumnInfo(name = "currency") val currency: String?
)