package com.example.data.network.api

import com.example.data.network.model.CartInfoDto
import com.example.data.network.model.PhoneDetailInfoDto
import com.example.data.network.model.PhoneInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhoneInfo(): PhoneInfoDto

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getPhoneDetailInfo(): PhoneDetailInfoDto

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartInfo(): CartInfoDto
}
