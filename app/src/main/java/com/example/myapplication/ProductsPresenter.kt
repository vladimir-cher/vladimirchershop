package com.example.myapplication

class ProductsPresenter(
    private val view: ProductsView
) {

    private val iphoneCase = Product(price = 123.5, salePercent = 30, productName = "IPhone Case")
    private val samsungCase = Product(price = 124.5, salePercent = 15, productName = "Samsung Case")

    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint(){
        view.print(iphoneCase.calcDiscountPrice())

        val allPrice: Double = 0.0
        products.forEach { product ->
            view.print(product.calcDiscountPrice())
        }
    }

    fun productNamePrint(){
        products.forEach { product ->
            view.print(product.getProductName())
        }
    }

    fun productNameAndPricePrint(){
        products.forEach { product ->
            view.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }
}