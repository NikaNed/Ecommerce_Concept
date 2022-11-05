package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.ecommerceconcept.data.HomeStore
import com.example.ecommerceconcept.domain.PhoneItem

object HotSalesDiffCallback: DiffUtil.ItemCallback<HomeStore>() {
    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}