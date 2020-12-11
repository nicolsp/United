package com.example.united.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "united_table")
data class TodosReal (@PrimaryKey val name: String,
                                    val region: String,
                      val subregion :String,
                      val population: Int,
                      val capital: String,
                      val allpha2code: String,
                      val allpha3code: String


                      )