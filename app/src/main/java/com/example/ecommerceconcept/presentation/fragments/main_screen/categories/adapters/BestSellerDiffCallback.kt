package com.example.ecommerceconcept.presentation.fragments.main_screen.categories.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.ecommerceconcept.domain.models.BestSeller

object BestSellerDiffCallback: DiffUtil.ItemCallback<BestSeller>() {
    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}