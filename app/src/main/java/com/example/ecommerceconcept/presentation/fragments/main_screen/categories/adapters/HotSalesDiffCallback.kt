package com.example.ecommerceconcept.presentation.fragments.main_screen.categories.adapters

import androidx.recyclerview.widget.DiffUtil

import com.example.ecommerceconcept.domain.models.HomeStore

object HotSalesDiffCallback: DiffUtil.ItemCallback<HomeStore>() {
    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}