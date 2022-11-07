package com.example.ecommerceconcept.presentation

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.data.BestSeller
import com.example.ecommerceconcept.data.HomeStore
import com.example.ecommerceconcept.databinding.RvItemBestSellerBinding
import com.example.ecommerceconcept.databinding.RvItemHotSalesBinding
import com.example.ecommerceconcept.domain.PhoneItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_books.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.rv_item_hot_sales.view.*

class BestSellerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = RvItemBestSellerBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(item: BestSeller) = with(binding) {
        tvNamePhone.text = item.title
        tvPricePhone.text = "$" + "%,d".format(item.price_without_discount)
        tvSubpricePhone.text = "$" + "%,d".format(item.discount_price)
        tvSubpricePhone.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        Picasso.get().load(item.picture).into(imPhone)
    }
}