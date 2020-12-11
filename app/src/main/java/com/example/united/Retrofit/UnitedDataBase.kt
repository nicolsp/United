package com.example.united.Retrofit

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.united.dao.UnitedDao
import com.example.united.entities.TodosReal

private const val DATA_BASE_NAME = "united_database"
@Database(entities = [TodosReal::class],version = 1,exportSchema = false)
abstract class unitedDataBase : RoomDatabase() {
    abstract fun unitedDao() : UnitedDao

    companion object {
        private var INSTANCE: unitedDataBase?= null

        fun getDataBase(context: Context) : unitedDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance

            }
            val instance = Room.databaseBuilder(
                context,unitedDataBase::class.java, DATA_BASE_NAME
            ).build()
            INSTANCE = instance
            return  instance
        }
    }
}