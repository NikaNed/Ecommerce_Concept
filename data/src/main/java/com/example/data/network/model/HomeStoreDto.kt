package com.example.data.network.model

import com.google.gson.annotations.SerializedName

data class HomeStoreDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_buy")
    val is_buy: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)