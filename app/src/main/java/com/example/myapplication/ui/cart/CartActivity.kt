package com.example.myapplication.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.CartProduct
import com.example.myapplication.presenter.CartPresenter
import com.example.myapplication.presenter.ICartView
import com.example.myapplication.ui.BaseActivity
import com.example.myapplication.ui.DetailedActivity
import com.example.myapplication.ui.DetailedActivity.Companion.PRODUCT_TAG
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : BaseActivity(), ICartView {
    private lateinit var cardAdapter: CartAdapter

    private val presenter = CartPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        with(cartProducts) {
            layoutManager = LinearLayoutManager(context)
            adapter = CartAdapter {
                presenter.onProductClick(it)
            }
                .also { cardAdapter = it }
        }
        presenter.attachView(this)
        presenter.getProducts()
    }

    override fun showProducts(products: List<CartProduct>) {
        cardAdapter.changeItemSource(products)
    }

    override fun showProductDerailed(product: CartProduct) {
        startActivity(Intent(this, DetailedActivity::class.java).apply {
            putExtra(PRODUCT_TAG, product)
        })
    }
}

