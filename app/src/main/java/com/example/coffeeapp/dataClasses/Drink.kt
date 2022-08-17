package com.example.coffeeapp.dataClasses

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("id") val id: Int,
    @SerializedName("price") val price: Double,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("name") val name: String,
    @SerializedName("size") val size: Int,
    @SerializedName("sugar") val sugar: Int,
    @SerializedName("description") val description: String,
    @SerializedName("is_added_to_cart") val is_added_to_cart: Boolean,
    @SerializedName("category") val categor: String,
    @SerializedName("bought_items_count") val bought_items_count: Int
)

//data class Drink(@SerializedName("name")val name:String,val imageURL:String)
object SharedList{
    var drinks:ArrayList<Drink>?= ArrayList()
    fun add(drink: Drink){
        drinks?.add(drink)
    }
    fun getAllItems():ArrayList<Drink>?
    {
        return drinks
    }
}