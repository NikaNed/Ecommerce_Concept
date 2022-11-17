package com.example.ecommerceconcept.presentation

import androidx.recyclerview.widget.DiffUtil

object PhoneDetailDiffCallback: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem:String, newItem:String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem:String, newItem:String): Boolean {
        return oldItem == newItem
    }
}