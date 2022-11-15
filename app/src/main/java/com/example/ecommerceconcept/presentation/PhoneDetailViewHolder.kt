package com.example.ecommerceconcept.presentation

import android.annotation.SuppressLint
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.data.network.PhoneDetailInfo
import com.example.ecommerceconcept.databinding.RvItemDetailBinding
import com.squareup.picasso.Picasso

class PhoneDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemDetailBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(item: PhoneDetailInfo) = with(binding) {
        Picasso.get().load(item.images?.get(position)).into(imPhone)

    }
}

