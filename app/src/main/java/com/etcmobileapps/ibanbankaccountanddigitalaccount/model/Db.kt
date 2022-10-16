package com.etcmobileapps.ibanbankaccountanddigitalaccount.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Account::class,Iban::class],
    version = 1
)

abstract class Db: RoomDatabase() {
    abstract fun getManagerDao(): ManagerDao
    companion object{
        private var instance: Db? = null
        fun getDatabase(context: Context): Db?{
            if (instance == null){
                instance = Room.databaseBuilder(context,
                    Db::class.java,
                    "database.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}