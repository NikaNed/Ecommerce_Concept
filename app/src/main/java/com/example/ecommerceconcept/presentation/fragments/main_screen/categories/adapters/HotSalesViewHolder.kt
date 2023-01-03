package com.example.ecommerceconcept.presentation.fragments.main_screen.categories.adapters

import android.annotation.SuppressLint
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.data.network.model.HomeStoreDto
import com.example.ecommerceconcept.databinding.RvItemHotSalesBinding
import com.example.ecommerceconcept.domain.models.HomeStore
import com.squareup.picasso.Picasso

class HotSalesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemHotSalesBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(item: HomeStore) = with(binding) {
        tvTitlePhone.text = item.title
        tvSubtitlePhone.text = item.subtitle
        cardNew.visibility = if (item.is_new) View.VISIBLE else View.GONE
        Picasso.get().load(item.picture).into(imAd)
    }
}