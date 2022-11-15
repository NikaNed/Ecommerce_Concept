package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.ecommerceconcept.data.network.PhoneDetailInfo
import com.example.ecommerceconcept.data.network.model.HomeStore

object PhoneDetailDiffCallback: DiffUtil.ItemCallback<PhoneDetailInfo>() {
    override fun areItemsTheSame(oldItem:PhoneDetailInfo, newItem:PhoneDetailInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem:PhoneDetailInfo, newItem:PhoneDetailInfo): Boolean {
        return oldItem == newItem
    }
}