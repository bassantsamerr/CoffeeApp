package com.example.coffeeapp


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeapp.dataClasses.Drink

class ListAdapter(var drinks:ArrayList<Drink>?): RecyclerView.Adapter<ListAdapter.DrinkViewHolder>(){
    class DrinkViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvDrink:TextView
        val ivPhoto:ImageView
        init{
            tvDrink=view.findViewById(R.id.tv_drink)
            ivPhoto=view.findViewById(R.id.iv_photo)
        }


    }

    override fun getItemCount():Int {
        return 5

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_drink,parent,false)
        return DrinkViewHolder(view)

    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink= drinks?.get(position)
        holder.tvDrink.text=drink?.name
        Glide.with(holder.itemView)
            .load(drink?.imageURL)
            .into(holder.ivPhoto)
        holder.itemView.setOnClickListener{
            val bundle=Bundle()
            bundle.putInt("id", drink?.id!!)

            val intent = Intent(it.context, preferenceActivity::class.java)
            intent.putExtras(bundle)
            it.context.startActivity(intent)

        }

    }





}