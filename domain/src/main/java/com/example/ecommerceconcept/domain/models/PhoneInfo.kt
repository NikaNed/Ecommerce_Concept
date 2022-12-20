package com.example.ecommerceconcept.domain.models

data class PhoneInfo(
    val best_seller: List<BestSeller> = listOf(),
    val home_store: List<HomeStore> = listOf(),
)

