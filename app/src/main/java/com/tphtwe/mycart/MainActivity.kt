package com.tphtwe.mycart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tphtwe.mycart.adapter.CartAdatpter
import com.tphtwe.mycart.model.Cart
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cart_item.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var arrCart=ArrayList<Cart>()
        arrCart.add(Cart(R.drawable.sugar,"Fine Grain Sugar",20.00,1,"$10 Discount"))
        arrCart.add(Cart(R.drawable.peanuts,"Peanuts",20.00,1,"$10 Discount"))
        arrCart.add(Cart(R.drawable.rice,"Dawat Rice",20.00,1,"$10 Discount"))

        cartRecycler.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=CartAdatpter(arrCart)
        }

    }
}