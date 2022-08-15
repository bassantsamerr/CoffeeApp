package com.example.coffeeapp.network

import com.example.coffeeapp.dataClasses.RegisterResponse
import com.example.coffeeapp.dataClasses.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

interface coffeeAppSerice {
    @POST ("api/register")
    fun register(@Body user: User): Call<RegisterResponse>
}
var service = Retrofit.Builder().baseUrl("https://reqres.in/").
addConverterFactory(GsonConverterFactory.create()).build()
    .create(coffeeAppSerice::class.java)

