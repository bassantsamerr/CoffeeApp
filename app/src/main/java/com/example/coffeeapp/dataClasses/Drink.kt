package com.example.coffeeapp.dataClasses

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("id") val id: Int=5,
    @SerializedName("price") val price: Double=10.0,
    @SerializedName("image") val imageURL: String="",
    @SerializedName("name") val name: String="",
    @SerializedName("size") var size: Int=5,
    @SerializedName("sugar") var sugar: Int=1,
    @SerializedName("description") val description: String="",
    @SerializedName("addedToCart") var is_added_to_cart: Boolean=false,
    @SerializedName("category") val categor: String="",
    @SerializedName("boughtItemsCount") var bought_items_count: Int=0
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
object BoughtItems{
    var drinks:ArrayList<Drink>?= ArrayList()
    fun add(drink: Drink){
        drinks?.add(drink)
    }
    fun getAllItems():ArrayList<Drink>?
    {
        return drinks
    }
}