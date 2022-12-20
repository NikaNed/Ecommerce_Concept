package com.example.ecommerceconcept.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ecommerceconcept.R
import com.example.data.network.model.BasketDto
import com.example.ecommerceconcept.presentation.CartDiffCallback
import com.example.ecommerceconcept.presentation.CartViewHolder

class CartAdapter : ListAdapter<BasketDto, CartViewHolder>(CartDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_cart,
            parent,
            false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}