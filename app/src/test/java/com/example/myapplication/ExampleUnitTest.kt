package com.example.myapplication

import com.example.myapplication.model.Product
import org.junit.Test

class ExampleUnitTest {

    private val presenter = Presenter()
    @Test
    fun example() {
        presenter.productNameAndPricePrint()
    }
}

class Presenter {

    private val iphoneCase = Product(
        price = 123.5,
        salePercent = 30,
        productName = "IPhone Case"
    )
    private val samsungCase = Product(
        price = 124.5,
        salePercent = 15,
        productName = "Samsung Case"
    )

    private val pricePrinter: PricePrinter = ConsolePricePrinter()

    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint(){
        products.forEach { product ->
            pricePrinter.print(product.calcDiscountPrice())
        }
    }

    fun productNamePrint(){
        products.forEach { product ->
            pricePrinter.print(product.getProductName())
        }
    }

    fun productNameAndPricePrint(){
        products.forEach { product ->
            pricePrinter.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }
}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val productName: String
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)

    fun getProductName(): String = productName
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)

    fun print(name: String)
}

class ConsolePricePrinter : PricePrinter {

    override fun print(price: Double) {
        println(price)
    }

    override fun print(name: String){
        println(name)
    }
}
