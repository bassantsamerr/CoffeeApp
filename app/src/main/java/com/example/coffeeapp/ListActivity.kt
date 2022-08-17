package com.example.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.dataClasses.Drink
import com.example.coffeeapp.network.coffeeAppSerice
import com.example.coffeeapp.network.service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_cart)
        var drinkName: TextView? = null
        var image: ImageView? = null
        var rv:RecyclerView?=null
        drinkName=findViewById(R.id.tv_drink)
        image=findViewById(R.id.iv_photo)
        rv=findViewById(R.id.rv_drinks)


        val call : Call<List<Drink>>
        val adapter=listAdapter(ArrayList())
        rv.adapter=adapter
        service.getAllProducts("Bearer ${token}" ).enqueue(object : Callback<List<Drink>> {
            override fun onResponse(call: Call<List<Drink>>, response: Response<List<Drink>>) {
                if (response.isSuccessful) {
                    Log.v("3", "onResponse ${response.body().toString()}")
                    adapter.drinks=response.body()
                    adapter.notifyDataSetChanged()


                } else {
                    Log.v("4", "onResponse ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Drink>>, t: Throwable) {
                Log.v("5", "onFailure ${t.localizedMessage} ")
            }
        })




    }
    fun startPreference() {
        val intent = Intent(this, preferenceActivity::class.java)
        startActivity(intent)
    }
}
