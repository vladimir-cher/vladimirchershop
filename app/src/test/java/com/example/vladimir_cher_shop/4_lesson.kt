package com.example.vladimir_cher_shop

import org.junit.Test

class LessonFour {

    @Test
    fun example() {

        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val samsungCase = Product(price = 124.5, salePercent = 15)

        val pricePrinter: PricePrinter = ConsolePricePrinter()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        pricePrinter.print(discountIphoneCasePrice)

        val discountSamsungCasePrice = samsungCase.calcDiscountPrice()
        pricePrinter.print(discountSamsungCasePrice)


        val products = listOf(iphoneCase, samsungCase)
        products.forEach { product ->
            val discountPrice = product.calcDiscountPrice()
            pricePrinter.print(discountPrice)

        }

        val discountPrices = products.map { product ->
            val discountPrice = product.calcDiscountPrice()
            return@map discountPrice

        }

        /* discountPrices.forEach { discountPrice ->
             pricePrinter.print(discountPrice)
         }*/

        forEach(products) { product ->
            val discountPrice = product.calcDiscountPrice()
            pricePrinter.print(discountPrice)
        }
    }

    private fun forEach(list: List<Product>, action: (Product) -> Unit) {
        for (item in list) {
            action(item)
        }


    }
}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double {
        val sale = price * salePercent / 100.0
        return price - sale
    } //= price * (1 - salePercent / 100.0)
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)

}

class ConsolePricePrinter : PricePrinter {

    override fun print(price: Double) {
        println(price)
    }
}