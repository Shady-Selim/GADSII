package com.example.gadsii.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apifactory {
    private const val BASE_URL = "https://gadsapi.herokuapp.com/api/"

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitApi: ApiClient = retrofit().create(ApiClient::class.java)
}