package com.example.data.network.model

import com.google.gson.annotations.SerializedName

 data class PhoneDetailInfoDto(
    @SerializedName("CPU")
    val CPU: String? = null,
    @SerializedName("camera")
    val camera: String,
    @SerializedName("capacity")
    val capacity: List<String>? = null,
    @SerializedName("color")
    val color: List<String>? = null,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<String>? = null,
    @SerializedName("isFavorites")
    val isFavorites: Boolean,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("sd")
    val sd: String,
    @SerializedName("ssd")
    val ssd: String,
    @SerializedName("title")
    val title: String
)