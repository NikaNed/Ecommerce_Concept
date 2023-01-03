package com.example.ecommerceconcept.data.network.model

import com.google.gson.annotations.SerializedName

data class PhoneInfoDto(
    @SerializedName("best_seller")
    val best_seller: List<BestSellerDto>,
    @SerializedName("home_store")
    val home_store: List<HomeStoreDto>,
)