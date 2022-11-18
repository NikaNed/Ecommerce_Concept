package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.data.data.network.model.Basket

object CartDiffCallback: DiffUtil.ItemCallback<Basket>() {
    override fun areItemsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem == newItem
    }
}