package com.example.ecommerceconcept.data.network.model

import com.google.gson.annotations.SerializedName

data class BasketDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("title")
    val title: String
)