package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.data.network.model.BestSellerDto

object BestSellerDiffCallback: DiffUtil.ItemCallback<BestSellerDto>() {
    override fun areItemsTheSame(oldItem: BestSellerDto, newItem: BestSellerDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSellerDto, newItem: BestSellerDto): Boolean {
        return oldItem == newItem
    }
}