package com.example.pounds.api

import com.example.pounds.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {private val retrofit by lazy{
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    val api: AlbumApi by lazy {
        retrofit.create(AlbumApi::class.java)
    }

}








/*  var api: AlbumApi? = null
    fun getInstance() : AlbumApi {
        if (api == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit.create(AlbumApi::class.java)
        }
        return api!!
    } */