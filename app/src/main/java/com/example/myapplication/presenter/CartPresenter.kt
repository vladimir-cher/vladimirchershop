package com.example.myapplication.presenter

import com.example.myapplication.model.CartProduct
import com.example.myapplication.model.CartProductFactory
import moxy.MvpPresenter

class CartPresenter() : MvpPresenter<ICartView>() {

    private val factory = CartProductFactory()

    private val myDataSet = listOf(
        factory.createCartProduct(1, "someProd0", "123321", 1200.0, 0),
        factory.createCartProduct(2, "someProd1", "123321", 1200.0, 0),
        factory.createCartProduct(3, "someProd2", "123321", 1200.0, 0),
        factory.createCartProduct(4, "someProd3", "123321", 1200.0, 0),
        factory.createCartProduct(5, "someProd4", "123321", 1200.0, 0),
        factory.createCartProduct(6, "someProd5", "123321", 1200.0, 0)
    )

    fun getProducts() {
        viewState.showProducts(myDataSet)
    }

    fun onProductClick(product: CartProduct) {
        viewState.showProductDerailed(product)
    }
}