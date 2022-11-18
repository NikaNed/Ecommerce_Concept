package com.example.ecommerceconcept.presentation

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.data.data.network.model.Basket
import com.example.ecommerceconcept.databinding.RvItemCartBinding
import com.squareup.picasso.Picasso

class CartViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemCartBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(item: Basket) = with(binding) {
        Picasso.get().load(item.images).into(imgPhoneCart)
        tvPhoneTitleCart.text = item.title
        tvPhonePriceCart.text = "$" + item.price.toString()
    }
}