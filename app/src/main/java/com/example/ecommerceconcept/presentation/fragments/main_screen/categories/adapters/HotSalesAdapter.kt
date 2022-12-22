package com.example.ecommerceconcept.presentation.fragments.main_screen.categories.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.domain.models.HomeStore

class HotSalesAdapter : ListAdapter<HomeStore, HotSalesViewHolder>(HotSalesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_hot_sales,
            parent,
            false)
        return HotSalesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}




