package com.example.data.mapper

import com.example.data.network.model.BestSellerDto
import com.example.data.network.model.HomeStoreDto
import com.example.data.network.model.PhoneInfoDto
import com.example.ecommerceconcept.domain.models.BestSeller
import com.example.ecommerceconcept.domain.models.HomeStore
import com.example.ecommerceconcept.domain.models.PhoneInfo
import javax.inject.Inject

class PhoneMapper
@Inject constructor()
{

    fun mapTDtoToEntityPhoneInfo(dto: PhoneInfoDto): PhoneInfo {
        return PhoneInfo(
            best_seller = mapDtoToEntityBestSeller(dto.best_seller),
            home_store = mapDtoToEntityHomeStore(dto.home_store)
        )
    }

    private fun mapDtoToEntityHomeStore(homeStore: List<HomeStoreDto>): List<HomeStore> {
        return homeStore.map {
            HomeStore(
                id = it.id,
                is_buy = it.is_buy,
                is_new = it.is_new,
                picture = it.picture,
                subtitle = it.subtitle,
                title = it.title
            )
        }
    }

    private fun mapDtoToEntityBestSeller(dto: List<BestSellerDto>): List<BestSeller> {
        return dto.map {
            BestSeller(
                discount_price = it.discount_price,
                id = it.id,
                is_favorites = it.is_favorites,
                picture = it.picture,
                price_without_discount = it.price_without_discount,
                title = it.title
            )
        }
    }

    //    fun PhoneInfoDto.toDomainModel(): PhoneInfo = PhoneInfo(
//        best_seller = this.best_seller.toDomainBestSeller(),
//        home_store = this.home_store.toDomainHomeStore()
//    )

//
//    fun List<BestSellerDto>.toDomainBestSeller(): List<BestSeller> = this.map {
//        BestSeller(
//            discount_price = it.discount_price,
//            id = it.id,
//            is_favorites = it.is_favorites,
//            picture = it.picture,
//            price_without_discount = it.price_without_discount,
//            title = it.title
//        )
//    }
//
//    fun List<HomeStoreDto>.toDomainHomeStore(): List<HomeStore> = this.map {
//        HomeStore(
//          id = it.id,
//            is_buy = it.is_buy,
//            is_new = it.is_new,
//            picture = it.picture,
//            subtitle = it.subtitle,
//            title = it.title
//        )
//    }
}