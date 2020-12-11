package com.example.united

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.united.Retrofit.unitedDataBase
import com.example.united.entities.TodosReal
import com.example.united.local.UnitedRepository
import kotlinx.coroutines.launch

class UnitedViewModel(application: Application): AndroidViewModel(application) {
    private var repository : UnitedRepository

    init {
        val unitedDao = unitedDataBase.getDataBase(application).unitedDao()
        repository = UnitedRepository(unitedDao)
        repository.getDataFromServer()
    }

    fun exposeLiveDataFromDatabase(): LiveData<List<TodosReal>> {
        return repository.mLiveData
    }

    fun obtainUnitedByID(id: String): LiveData<TodosReal> {
        return repository.obtainUnitedinByID(id)
    }

    fun updateUnited(todosReal: TodosReal)= viewModelScope.launch {
        repository.updateUnited(todosReal)
    }
}