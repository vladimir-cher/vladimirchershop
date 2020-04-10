package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(), ProductsView{

    private val presenter = ProductsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.pricePrint()
    }

    override fun print(price: Double) {
//        Toast.makeText(this, "Price: $price",Toast.LENGTH_LONG).show()
        Log.d("Print", "Price: $price")
    }

    override fun print(name: String) {
//        TODO("Not yet implemented")
    }
}
