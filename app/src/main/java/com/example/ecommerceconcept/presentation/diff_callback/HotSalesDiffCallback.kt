package com.example.ecommerceconcept.presentation.diff_callback

import androidx.recyclerview.widget.DiffUtil
import com.example.data.network.model.HomeStoreDto
import com.example.ecommerceconcept.domain.models.HomeStore

object HotSalesDiffCallback: DiffUtil.ItemCallback<HomeStore>() {
    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}