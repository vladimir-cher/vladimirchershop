package com.example.myapplication.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.CartProduct

class CartAdapter(
    private val onProductClick: (CartProduct) -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    private var dataSet: List<CartProduct> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false) as ConstraintLayout

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.layout.setOnClickListener { onProductClick(item) }
        holder.layout.findViewById<TextView>(R.id.tvCartItemTitle).text = item.title
        holder.layout.findViewById<TextView>(R.id.tvCartItemPrice).text = item.lot.price.toString()
        holder.layout.findViewById<TextView>(R.id.tvCartItemDiscount).text =
            item.lot.salePercent.toString() + " %"
        holder.layout.findViewById<TextView>(R.id.tvCartItemDiscountPrice).text =
            item.lot.calcDiscountPrice().toString()

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun changeItemSource(products: List<CartProduct>) {
        dataSet = products
        notifyDataSetChanged()
    }
}