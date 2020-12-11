package com.example.united.Retrofit

data class ResponseApi(
    val altSpellings: List<String>,
    val name: String,
    val region: String,
    val subregion: String,
    val population: Int,
    val capital: String,
    val allpha2code: String,
    val allpha3code: String
)

data class Uniteeeed(
    val name: String
)