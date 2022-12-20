package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.data.network.model.BasketDto

object CartDiffCallback: DiffUtil.ItemCallback<BasketDto>() {
    override fun areItemsTheSame(oldItem: BasketDto, newItem: BasketDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BasketDto, newItem: BasketDto): Boolean {
        return oldItem == newItem
    }
}