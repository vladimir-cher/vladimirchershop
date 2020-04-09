package com.example.vladimir_cher_shop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


class MainActivity : AppCompatActivity(), ProductView {


    private val presenter = ProductPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.pricePrint()
    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price:$price", Toast.LENGTH_LONG).show()
    }

}
