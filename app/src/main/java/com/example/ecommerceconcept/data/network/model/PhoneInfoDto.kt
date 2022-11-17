package com.example.ecommerceconcept.data.network.model

import com.google.gson.annotations.SerializedName

data class PhoneInfoDto(
    @SerializedName("best_seller")
    val best_seller: List<BestSeller>,
    @SerializedName("home_store")
    val home_store: List<HomeStore>,
)