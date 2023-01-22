package com.example.ecommerceconcept.data.repositories

import android.util.Log
import com.example.ecommerceconcept.data.mapper.PhoneMapper
import com.example.ecommerceconcept.data.network.api.ApiService
import com.example.ecommerceconcept.domain.PhoneRepository
import com.example.ecommerceconcept.domain.models.CartInfo
import com.example.ecommerceconcept.domain.models.PhoneDetailInfo
import com.example.ecommerceconcept.domain.models.PhoneInfo
import javax.inject.Inject

class PhoneRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: PhoneMapper,
) : PhoneRepository {

    override suspend fun getPhoneInfoList(): PhoneInfo? {
        return try {
            val response = apiService.getPhoneInfo()
            mapper.mapToDtoToEntityPhoneInfo(response)
        } catch (e: Exception) {
            Log.d("TAG", e.message.toString())
            null
        }
    }

    override suspend fun getPhoneDetailInfo(): PhoneDetailInfo? {
        return try {
            val responseDetail = apiService.getPhoneDetailInfo()
            mapper.mapDtoToEntityDetailInfo(responseDetail)
        } catch (e: Exception) {
            Log.d("TAG", e.message.toString())
            null
        }
    }

    override suspend fun getCartInfo(): CartInfo? {
        return try {
            val responseCart = apiService.getCartInfo()
            mapper.mapDtoToEntityCart(responseCart)
        } catch (e: Exception) {
            Log.d("TAG", e.message.toString())
            null
        }
    }
}