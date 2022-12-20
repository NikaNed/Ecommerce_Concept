package com.example.data.network.model

import com.google.gson.annotations.SerializedName

data class CartInfoDto(
    @SerializedName("basket")
    val basket: List<BasketDto>,
    @SerializedName("delivery")
    val delivery: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("total")
    val total: Int
)