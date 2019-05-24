package com.tahn.retrofit2demo.RetrofitAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {
    private val BASEURL = "http://api.themoviedb.org/3/"

    fun getClient(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}