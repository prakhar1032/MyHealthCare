package com.care.myhealthcare.api

import com.care.myhealthcare.api.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




object ApiClient {

    private fun getRetrofit():Retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newApi:ApiInterface= getRetrofit().create(ApiInterface::class.java)


    }
