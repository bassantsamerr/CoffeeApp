package com.example.coffeeapp.network

import com.example.coffeeapp.dataClasses.Drink
import com.example.coffeeapp.dataClasses.User
import com.example.example.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface coffeeAppSerice {
    @POST ("api/v1/signup")
    fun signup(@Body user: User): Call<Unit>
    @POST ("/user/v1/login")
    fun login(@Body user: User): Call<LoginResponse>
    @GET ("/products/getAllProducts/")
    fun getAllProducts(@Header("Authorization") auth:String):Call<ArrayList<Drink>>
}

val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
val client=  OkHttpClient.Builder().addInterceptor(logging).build();
var service = Retrofit.Builder().baseUrl("https://coffeeshopv.herokuapp.com").
addConverterFactory(GsonConverterFactory.create()).client(client).build()
    .create(coffeeAppSerice::class.java)

