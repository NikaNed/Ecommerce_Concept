package com.example.ecommerceconcept.domain

data class PhoneItem(
    val id: Int = 1,
    val new: Boolean = false,
    val title: String,
    val picture: String,
    val buy: Boolean = false,
    val subtitle: String,
    val favorite: Boolean = false,
    val discountPrice: Int,
    val priceWithoutDiscount: Int
)
