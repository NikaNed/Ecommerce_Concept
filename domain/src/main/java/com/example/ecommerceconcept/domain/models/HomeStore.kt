package com.example.ecommerceconcept.domain.models

data class HomeStore(
    val id: Int = 0,
    val is_buy: Boolean = false,
    val is_new: Boolean,
    val picture: String = "",
    val subtitle: String = "",
    val title: String = ""
)
