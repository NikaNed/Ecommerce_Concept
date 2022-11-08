package com.example.ecommerceconcept.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.data.network.model.HomeStore
import com.example.ecommerceconcept.presentation.HotSalesDiffCallback
import com.example.ecommerceconcept.presentation.HotSalesViewHolder

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




