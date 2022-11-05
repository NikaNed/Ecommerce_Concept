package com.example.ecommerceconcept.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://run.mocky.io/v3/"

//    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
//        .build()

    fun create(): ApiService{
         val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        .build()
        return  retrofit.create(ApiService::class.java)
    }
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .client(okHttpClient)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val apiService: ApiService =
//        retrofit.create(ApiService::class.java)
}


