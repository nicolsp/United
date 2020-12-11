package com.example.united.Retrofit

import com.example.united.entities.entityUnitedItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("name/united")
    fun fetchUnited(): Call<ResponseApi>

}