package com.ricardosecchin.primecep.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CepService {

    private val URL = "https://viacep.com.br/ws/"


    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun service(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}