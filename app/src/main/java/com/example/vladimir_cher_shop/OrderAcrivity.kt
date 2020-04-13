package com.example.vladimir_cher_shop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_order.*


class OrderActivity : AppCompatActivity(), ProductView {


    private val presenter = ProductPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        presenter.pricePrint()

    }

    override fun print(price: Double) {
        firstSumValue.text = "$price"
        Toast.makeText(this, "Price:$price", Toast.LENGTH_LONG).show()

        val product = Product(14.5, 5, "Something")
        finalSumValue.text = "${product.calcDiscountPrice()}"
        Toast.makeText(this, "Price:${product.calcDiscountPrice()}", Toast.LENGTH_LONG).show()

        discountValue.text = "${product.getSalePercent()}"
        Toast.makeText(this, "Price:${product.getSalePercent()}", Toast.LENGTH_LONG).show()
    }

    //override fun print(price: Double) {
    fun orderPrint() {
        val product = Product(14.5, 5, "Something")
        finalSumValue.text = "${product.calcDiscountPrice()}"
        Toast.makeText(this, "Price:${product.calcDiscountPrice()}", Toast.LENGTH_LONG).show()


        // firstSumValue.text = "$price"
        //Toast.makeText(this, "Price:$price", Toast.LENGTH_LONG).show()

        discountValue.text = "${product.getSalePercent()}"
        Toast.makeText(this, "Price:${product.getSalePercent()}", Toast.LENGTH_LONG).show()

    }

}