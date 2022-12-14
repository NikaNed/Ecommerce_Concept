package com.example.ecommerceconcept.presentation.fragments.main_screen.categories.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ListAdapter
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.domain.models.BestSeller

class BestSellerAdapter (private val listener: BestSellerListener):
    ListAdapter<BestSeller, BestSellerViewHolder>(BestSellerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_best_seller,
            parent,
            false)
        return BestSellerViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface BestSellerListener{
        fun onClick(product: BestSeller)
    }
}




