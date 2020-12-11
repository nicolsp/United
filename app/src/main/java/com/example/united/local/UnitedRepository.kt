package com.example.united.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.united.Retrofit.ResponseApi
import com.example.united.Retrofit.RetrofitUnited

import com.example.united.Retrofit.Uniteeeed
import com.example.united.dao.UnitedDao
import com.example.united.entities.TodosReal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UnitedRepository(private val unitedDao: UnitedDao) {
    private val service = RetrofitUnited.retrofitInstance()
    val mLiveData = unitedDao.getAllUnitedFromBD()

        fun obtainUnitedinByID(id: String): LiveData<TodosReal> {
            return unitedDao.getUnitedByID(id)
        }

    suspend fun updateUnited(todosReal: TodosReal) {
        unitedDao.updateUnited(todosReal)
    }

    fun getDataFromServer() {
        val call = service.fetchUnited()
        call.enqueue(object : Callback<ResponseApi> {

            override fun onFailure(call: Call<ResponseApi>, t: Throwable) {
                Log.e("Repository", t.message.toString())
            }
            override fun onResponse(call: Call<ResponseApi>, response: Response<ResponseApi>) {
                when (response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                              for (item in response.body()!!.altSpellings) {
                                  // unitedDao.insertAllUnited(convert(it))

                              }
                        }
                    }
                    in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())

                }
            }
        })

        }
    fun convert(listFromNetwork: List<ResponseApi>): List<TodosReal> {
        val listmutable = mutableListOf<TodosReal>()
        listFromNetwork.map {
            listmutable.add(
                TodosReal(it.allpha2code,
                it.allpha3code,
                it.capital,
                it.population,
                it.capital,
                it.name,
                it.region)
            )
        }

return listmutable

    }


}