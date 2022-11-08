package com.example.ecommerceconcept.data.network.model

import com.google.gson.annotations.SerializedName

data class PhoneInfoDto(
    @SerializedName("best_seller")
    val best_seller: List<BestSeller>,
    @SerializedName("home_store")
    val home_store: List<HomeStore>,
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("is_buy")
//    val is_buy: Boolean,
//    @SerializedName("is_new")
//    val is_new: Boolean,
//    @SerializedName("discount_price")
//    val discount_price: Int,
//    @SerializedName("is_favorites")
//    val is_favorites: Boolean,
//    @SerializedName("picture")
//    val picture: String,
//    @SerializedName("price_without_discount")
//    val price_without_discount: Int,
//    @SerializedName("title")
//    val title: String,
//    @SerializedName("subtitle")
//    val subtitle: String
)