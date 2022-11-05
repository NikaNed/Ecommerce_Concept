package com.example.ecommerceconcept.presentation

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.data.HomeStore
import com.example.ecommerceconcept.databinding.RvItemHotSalesBinding
import com.example.ecommerceconcept.domain.PhoneItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_books.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.rv_item_hot_sales.view.*

class HotSalesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemHotSalesBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(item: HomeStore) = with(binding) {
        tvTitlePhone.text = item.title
        tvSubtitlePhone.text = item.subtitle
        Picasso.get().load(item.picture).into(imAd)
    }
}