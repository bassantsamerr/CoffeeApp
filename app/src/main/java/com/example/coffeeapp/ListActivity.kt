package com.example.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.dataClasses.Drink
import com.example.coffeeapp.dataClasses.SharedList
import com.example.coffeeapp.network.service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        var drinkName: TextView? = null
        var image: ImageView? = null
        var rv:RecyclerView?=null
        drinkName=findViewById(R.id.tv_drink)
        image=findViewById(R.id.iv_photo)
        rv=findViewById(R.id.rv_list)
        val d1=Drink()
        val d2=Drink()

        service.getAllProducts("Bearer ${token}" ).enqueue(object : Callback<ArrayList<Drink>> {
            override fun onResponse(call: Call<ArrayList<Drink>>, response: Response<ArrayList<Drink>>) {
                if (response.isSuccessful) {
                    val arr=ArrayList<Drink>()
                    arr.add(d1)
                    arr.add(d2)
                    val adapter=ListAdapter(arr)
                    rv.adapter=adapter
                    Log.v("3", "onResponse ${response.body().toString()}")
                    adapter.drinks=response.body()
                    adapter.notifyDataSetChanged()
                    SharedList.drinks=response.body()

                } else {
                    Log.v("4", "onResponse ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ArrayList<Drink>>, t: Throwable) {
                Log.v("5", "onFailure ${t.localizedMessage} ")
            }
        })




    }
    fun startPreference() {
        val intent = Intent(this, preferenceActivity::class.java)
        startActivity(intent)
    }
}
