package com.example.ecommerceconcept.domain

import com.example.data.data.network.model.CartInfo
import com.example.data.data.network.model.PhoneDetailInfo
import com.example.data.data.network.model.PhoneInfoDto
import retrofit2.Response

interface PhoneRepository {

    suspend fun getPhoneInfoList(): Response<PhoneInfoDto>

    suspend fun getPhoneDetailInfo():  Response<PhoneDetailInfo>

    suspend fun getCartInfo(): Response<CartInfo>

}
