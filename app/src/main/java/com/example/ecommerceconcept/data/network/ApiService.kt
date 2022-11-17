package com.example.ecommerceconcept.data.network

import com.example.ecommerceconcept.data.network.model.CartInfo
import com.example.ecommerceconcept.data.network.model.PhoneDetailInfo
import com.example.ecommerceconcept.data.network.model.PhoneInfoDto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    fun getPhoneInfo(): Call<PhoneInfoDto>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getPhoneDetailInfo(): Call<PhoneDetailInfo>

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun getCartInfo(): Call<CartInfo>

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
