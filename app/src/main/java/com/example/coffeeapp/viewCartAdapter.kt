package com.example.coffeeapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeapp.dataClasses.Drink

class viewCartAdapter(private val drinks:ArrayList<Drink>): RecyclerView.Adapter<viewCartAdapter.viewCartViewHolder>(){
    class viewCartViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvDrink:TextView
        val ivPhoto:ImageView
        val quantity:TextView
        val price:TextView

        init{
            tvDrink=view.findViewById(R.id.tv_drink_name)
            ivPhoto=view.findViewById(R.id.iv_photo)
            quantity=view.findViewById(R.id.tv_quantity)
            price=view.findViewById(R.id.tv_price)
        }
    }

    override fun onBindViewHolder(holder: viewCartViewHolder, position: Int) {
        val drink=drinks[position]
        holder.tvDrink.text=drink.name
        holder.price.text=(drink.price*drink.bought_items_count).toString()
        holder.quantity.text= "x${drink.bought_items_count.toString()}"
        Glide.with(holder.itemView)
            .load(drink.imageURL)
            .into(holder.ivPhoto)
    }

    override fun getItemCount(): Int =drinks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewCartViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_drink_bought,parent,false)
        return viewCartViewHolder(view)

    }


}