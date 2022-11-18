package com.example.ecommerceconcept.presentation

import android.annotation.SuppressLint
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.data.data.network.model.HomeStore
import com.example.ecommerceconcept.databinding.RvItemHotSalesBinding
import com.squareup.picasso.Picasso

class HotSalesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemHotSalesBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(item: HomeStore) = with(binding) {
        tvTitlePhone.text = item.title
        tvSubtitlePhone.text = item.subtitle
        Picasso.get().load(item.picture).into(imAd)
        if(item.is_new == null){
            imNew.isVisible = false
        }
    }
}