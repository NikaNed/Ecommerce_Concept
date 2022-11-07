package com.example.ecommerceconcept.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.data.BestSeller
import com.example.ecommerceconcept.data.HomeStore
import com.example.ecommerceconcept.presentation.BestSellerDiffCallback
import com.example.ecommerceconcept.presentation.BestSellerViewHolder
import com.example.ecommerceconcept.presentation.HotSalesDiffCallback
import com.example.ecommerceconcept.presentation.HotSalesViewHolder

class BestSellerAdapter : ListAdapter<BestSeller, BestSellerViewHolder>( BestSellerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_best_seller,
            parent,
            false)
        return BestSellerViewHolder(view)
    }


    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}




