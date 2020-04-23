package com.example.myapplication.ui

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.CartProduct
import com.example.myapplication.presenter.DetailedPresenter
import com.example.myapplication.presenter.DetailedView
import kotlinx.android.synthetic.main.activity_detailed.*

class DetailedActivity : BaseActivity(),
    DetailedView {

    private val presenter =
        DetailedPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val product = intent?.getParcelableExtra<CartProduct>(PRODUCT_TAG) ?: return
        Glide
            .with(ivDetailedImage.context)
            .load(product.imageUrl)
            .error(R.mipmap.ic_launcher)
            .into(ivDetailedImage)
        tvDetailedTitle.text = product.title
        tvDetailedPrice.text = product.lot.calcDiscountPrice().toString()
        presenter.onProductShow(product)
    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}

