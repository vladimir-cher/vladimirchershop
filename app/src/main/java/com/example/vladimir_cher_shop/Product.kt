package com.example.vladimir_cher_shop

class Product
/**
 * Must be positive
 */
    (
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
    fun calcDiscountPrice(): Double {
        val sale = price * salePercent / 100.0
        return price - sale
    } //= price * (1 - salePercent / 100.0)

    fun getSalePercent(): Int {
        return this.salePercent
    }


    fun getProductName(): String = productName
}