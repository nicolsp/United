package com.example.united.entities


import com.google.gson.annotations.SerializedName

data class RegionalBloc(
    @SerializedName("acronym")
    val acronym: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("otherAcronyms")
    val otherAcronyms: List<Any>?,
    @SerializedName("otherNames")
    val otherNames: List<String>?
)