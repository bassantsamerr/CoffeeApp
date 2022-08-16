package com.example.coffeeapp.dataClasses

import com.google.gson.annotations.SerializedName

data class Drink(@SerializedName("id")val id:Int,
                 @SerializedName("name")val name:String,
                 @SerializedName("price")val price:Double,
                 val imageURL:String,
                 @SerializedName("size")val size:Int,
                 @SerializedName("sugar")val sugar:Int,
                 @SerializedName("description")val description:String,
                 @SerializedName("is_added_to_cart")val is_added_to_cart:Boolean,
                 @SerializedName("category")val categor:String,
                 @SerializedName("bought_items_count")val bought_items_count:Int)
