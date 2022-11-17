package com.example.ecommerceconcept.data.network.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BestSeller(
    @SerializedName("discount_price")
    val discount_price: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_favorites")
    val is_favorites: Boolean,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("price_without_discount")
    val price_without_discount: Int,
    @SerializedName("title")
    val title: String
) : Serializable