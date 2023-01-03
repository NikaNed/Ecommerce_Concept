package com.example.ecommerceconcept.domain.models

data class BestSeller(
    val discount_price: Int = 0,
    val id: Int = 0,
    val is_favorites: Boolean,
    val picture: String = "",
    val price_without_discount: Int = 0,
    val title: String = ""
)
