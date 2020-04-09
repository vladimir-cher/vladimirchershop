package com.example.vladimir_cher_shop

class ProductPresenter(private val view: ProductView) {

    private val iphoneCase = Product(price = 123.5, salePercent = 30, productName = "iphoneCase")
    private val samsungCase = Product(price = 124.5, salePercent = 15, productName = "samsungCase")

    //val pricePrinter: PricePrinter = ConsolePricePrinter()

    val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
    // pricePrinter.print(discountIphoneCasePrice)

    val discountSamsungCasePrice = samsungCase.calcDiscountPrice()

    //pricePrinter.print(discountSamsungCasePrice)

    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint() {

        products.forEach { product ->
            val discountPrice = product.calcDiscountPrice()
            view.print(discountPrice)
        }


        /*  forEach(products) { product ->
              val discountPrice = product.calcDiscountPrice()
              pricePrinter.print(discountPrice)
          }*/


        val discountPrices = products.map { product ->
            val discountPrice = product.calcDiscountPrice()
            return@map discountPrice
        }
    }


    /* fun productNamePrint() {
         products.forEach {product ->
             view.print(product.getProductName())
         }

     }*/

}