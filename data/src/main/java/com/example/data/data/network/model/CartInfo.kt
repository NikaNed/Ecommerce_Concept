package com.example.data.data.network.model

import com.google.gson.annotations.SerializedName

data class CartInfo(
    @SerializedName("basket")
    val basket: List<Basket>,
    @SerializedName("delivery")
    val delivery: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("total")
    val total: Int
)