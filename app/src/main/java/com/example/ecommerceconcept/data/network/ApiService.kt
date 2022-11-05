package com.example.ecommerceconcept.data.network

import com.example.ecommerceconcept.data.HomeStore
import com.example.ecommerceconcept.data.PhoneInfoDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    fun getPhoneInfo(): Call<PhoneInfoDto>

    companion object{
        private const val BASE_URL = "https://run.mocky.io/v3/"
        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  retrofit.create(ApiService::class.java)
        }
    }
}
