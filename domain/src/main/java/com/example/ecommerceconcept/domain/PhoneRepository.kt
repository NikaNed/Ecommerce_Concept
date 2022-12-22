package com.example.ecommerceconcept.domain

import com.example.ecommerceconcept.domain.models.CartInfo
import com.example.ecommerceconcept.domain.models.PhoneDetailInfo
import com.example.ecommerceconcept.domain.models.PhoneInfo

interface PhoneRepository {

    suspend fun getPhoneInfoList(): PhoneInfo?

    suspend fun getPhoneDetailInfo(): PhoneDetailInfo?

    suspend fun getCartInfo(): CartInfo?

}
