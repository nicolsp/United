package com.example.united.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.united.entities.TodosReal

@Dao
interface UnitedDao {

    @Query("SELECT * FROM united_table")
    fun getAllUnitedFromBD(): LiveData<List<TodosReal>>

    @Query("SELECT * FROM united_table WHERE name =:id")
    fun getUnitedByID(id: String): LiveData<TodosReal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUnited(mUnited: TodosReal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun MuchosUnited(unites: List<TodosReal>)

    @Update
    suspend fun updateUnited(uni: TodosReal)

}