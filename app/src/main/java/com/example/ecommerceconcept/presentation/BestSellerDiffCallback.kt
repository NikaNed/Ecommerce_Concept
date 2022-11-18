package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.data.data.network.model.BestSeller

object BestSellerDiffCallback: DiffUtil.ItemCallback<BestSeller>() {
    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}