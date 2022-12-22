package com.example.data.mapper

import com.example.data.network.model.*
import com.example.ecommerceconcept.domain.models.*
import javax.inject.Inject

class PhoneMapper @Inject constructor() {

    fun mapToDtoToEntityPhoneInfo(dto: PhoneInfoDto): PhoneInfo {
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

    fun mapDtoToEntityDetailInfo(dto: PhoneDetailInfoDto) = PhoneDetailInfo(
        CPU = dto.CPU,
        camera = dto.camera,
        capacity = dto.capacity.orEmpty(),
        color = dto.color.orEmpty(),
        id = dto.id,
        images = dto.images.orEmpty(),
        isFavorites = dto.isFavorites,
        price = dto.price,
        rating = dto.rating,
        sd = dto.sd,
        ssd = dto.ssd,
        title = dto.title
    )

    fun mapDtoToEntityCart(dto: CartInfoDto) = CartInfo(
        basket = mapDtoToEntityBasket(dto.basket),
        delivery = dto.delivery,
        id = dto.id,
        total = dto.total
    )

    private fun mapDtoToEntityBasket(dto: List<BasketDto>): List<Basket> {
        return dto.map {
            Basket(
               id = it.id,
               images = it.images,
               price = it.price,
               title = it.title
            )
        }
    }
}
