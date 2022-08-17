package com.example.coffeeapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeapp.dataClasses.Drink

class listAdapter(var drinks:List<Drink>?): RecyclerView.Adapter<listAdapter.drinkViewHolder>(){
    class drinkViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvDrink:TextView
        val ivPhoto:ImageView
        init{
            tvDrink=view.findViewById(R.id.tv_drink)
            ivPhoto=view.findViewById(R.id.iv_photo)
        }
//        view.setOnClickListener{
//            startPreference()
//        }
//        fun startPreference() {
//            val intent = Intent(this, preferenceActivity::class.java)
//            startActivity(intent)
//        }

    }

    override fun getItemCount():Int {
        if(drinks?.size!=null)
          return drinks?.size!!
        else{return 0}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): drinkViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_drink,parent,false)
        return drinkViewHolder(view)

    }

    override fun onBindViewHolder(holder: drinkViewHolder, position: Int) {
        val drink= drinks?.get(position)
        holder.tvDrink.text=drink?.name
        Glide.with(holder.itemView)
            .load(drink?.imageURL)
            .into(holder.ivPhoto)

    }





}