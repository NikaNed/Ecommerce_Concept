package com.example.ecommerceconcept.data.network.model

import com.google.gson.annotations.SerializedName

data class HomeStore(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_buy")
    val is_buy: Boolean? = null,
    @SerializedName("is_new")
    val is_new: Boolean? = null,
    @SerializedName("picture")
    val picture: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("title")
    val title: String? = null
)