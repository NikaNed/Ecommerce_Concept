package com.example.ecommerceconcept.presentation.fragments.detail_screen.adapters

import androidx.recyclerview.widget.DiffUtil

object PhoneDetailDiffCallback: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem:String, newItem:String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem:String, newItem:String): Boolean {
        return oldItem == newItem
    }
}