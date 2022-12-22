package com.example.ecommerceconcept.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.domain.models.BestSeller
import com.example.ecommerceconcept.presentation.BestSellerDiffCallback
import com.example.ecommerceconcept.presentation.BestSellerViewHolder

class BestSellerAdapter (private val listener: BestSellerListener):
    ListAdapter<BestSeller, BestSellerViewHolder>(BestSellerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_best_seller,
            parent,
            false)
        return BestSellerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface BestSellerListener{
        fun onClick(product: BestSeller)
    }
}




