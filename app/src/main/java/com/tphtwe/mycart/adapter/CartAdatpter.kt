package com.tphtwe.mycart.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tphtwe.mycart.R
import com.tphtwe.mycart.model.Cart
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdatpter(var cartArr:ArrayList<Cart>):RecyclerView.Adapter<CartAdatpter.CartViewHolder>() {
    class CartViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindCart(cart: Cart){
            itemView.img.setImageResource(cart.image)
            itemView.txtName.text=cart.name
            itemView.price.text=cart.price.toString()
            itemView.weight.text=cart.weight.toString()
            itemView.txtDiscount.text=cart.discount


            itemView.btnAdd.setOnClickListener {
                var weight=itemView.weight.text.toString().toInt()
                weight++
                itemView.weight.text=weight.toString()
                var price:Double=cart.price
                price*=weight
                itemView.price.text=price.toString()

            }
            itemView.btnMinus.setOnClickListener {
                if(itemView.weight.text.toString().toInt()>0){
               var weight=itemView.weight.text.toString().toInt()
                    weight--
                itemView.weight.text=weight.toString()
                var price=cart.price.toDouble()
                    price=price*weight
                itemView.price.text=price.toString()
                }


            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartArr.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bindCart(cartArr[position])
    }
}