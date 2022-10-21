package com.apimarvel.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://gateway.marvel.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}