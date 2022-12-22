package com.example.ecommerceconcept.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.diff_callback.PhoneDetailDiffCallback
import com.example.ecommerceconcept.presentation.view_holder.PhoneDetailViewHolder

class PhoneDetailAdapter: ListAdapter<String, PhoneDetailViewHolder>(PhoneDetailDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneDetailViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_detail,
            parent,
            false)
        return PhoneDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhoneDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}




