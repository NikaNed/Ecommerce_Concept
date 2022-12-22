package com.example.ecommerceconcept.presentation.view_holder

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.RvItemBestSellerBinding
import com.example.ecommerceconcept.domain.models.BestSeller
import com.example.ecommerceconcept.presentation.adapters.BestSellerAdapter
import com.squareup.picasso.Picasso

class BestSellerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemBestSellerBinding.bind(view)

    @RequiresApi(Build.VERSION_CODES.S)
    @SuppressLint("SetTextI18n")
    fun bind(item: BestSeller, listener: BestSellerAdapter.BestSellerListener) = with(binding) {
        tvNamePhone.text = item.title
        tvPricePhone.text = "$" + "%,d".format(item.price_without_discount)
        tvSubpricePhone.text = "$" + "%,d".format(item.discount_price)
        tvSubpricePhone.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        Picasso.get().load(item.picture).into(imPhone)
        itemView.setOnClickListener {
            listener.onClick(item)
        }
    }
}

