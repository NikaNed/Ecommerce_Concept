package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.data.network.model.HomeStoreDto

object HotSalesDiffCallback: DiffUtil.ItemCallback<HomeStoreDto>() {
    override fun areItemsTheSame(oldItem: HomeStoreDto, newItem: HomeStoreDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStoreDto, newItem: HomeStoreDto): Boolean {
        return oldItem == newItem
    }
}