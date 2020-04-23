package com.example.myapplication.presenter

import com.example.myapplication.model.CartProduct
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ICartView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProducts(products: List<CartProduct>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProductDerailed(product: CartProduct)

}