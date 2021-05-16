package com.example.be_sopt_seminar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object SoptServiceImpl {
    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)
}