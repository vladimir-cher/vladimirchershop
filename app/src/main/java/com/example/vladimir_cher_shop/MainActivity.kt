package com.example.vladimir_cher_shop

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ProductView {


    private val presenter = ProductPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.pricePrint()
    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price:$price", Toast.LENGTH_LONG).show()
        checkoutSumValue.text = "sdf"

        /* checkoutPay.setOnClickListener {
             Toast.makeText(this, "test Toast", Toast.LENGTH_LONG).show()
 }*/

        checkoutPay.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

    }

}
