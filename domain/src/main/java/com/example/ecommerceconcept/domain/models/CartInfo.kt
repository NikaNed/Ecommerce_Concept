package com.example.ecommerceconcept.domain.models

data class CartInfo(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int,
)