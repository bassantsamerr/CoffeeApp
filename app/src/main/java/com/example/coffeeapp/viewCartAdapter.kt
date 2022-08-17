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

class drinksAdapter(private val drinks:ArrayList<Drink>): RecyclerView.Adapter<drinksAdapter.drinkViewHolder>(){
    class drinkViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvDrink:TextView
        val ivPhoto:ImageView
        init{
            tvDrink=view.findViewById(R.id.tv_drink)
            ivPhoto=view.findViewById(R.id.iv_photo)
        }
    }

    override fun onBindViewHolder(holder: drinkViewHolder, position: Int) {
        val drink=drinks[position]
        holder.tvDrink.text=drink.name
        Glide.with(holder.itemView)
            .load(drink.imageURL)
            .into(holder.ivPhoto)
    }

    override fun getItemCount(): Int =drinks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): drinkViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_drink,parent,false)
        return drinkViewHolder(view)

    }


}