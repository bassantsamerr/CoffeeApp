package com.example.coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.dataClasses.BoughtItems
import com.example.coffeeapp.dataClasses.Drink
import com.example.coffeeapp.dataClasses.SharedList

val arraylist=ArrayList<Drink>()

class viewCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_cart)
     //   val arraylist=ArrayList<Drink>(5)
        val layoutManager=LinearLayoutManager(this)
//        arraylist.add((Drink("mocha","https://picsum.photos/100/150")))
//        arraylist.toArray()
        val adapter= BoughtItems.getAllItems()?.let { viewCartAdapter(it) }
        val rvDrinks:RecyclerView=findViewById(R.id.rv_drinks)
        rvDrinks.layoutManager= layoutManager
        rvDrinks.adapter=adapter
//        val btnMenu = findViewById<Button>(R.id.btn_menu)
//        btnMenu.setOnClickListener{
//            startChoices()
//        }
    }
//    fun startChoices() {
////        val layoutManager=LinearLayoutManager(this)
////        val intent = Intent(this, choicesActivity::class.java)
////        val adapter= BoughtItems.delete()?.let { viewCartAdapter(it) }
////        val rvDrinks:RecyclerView=findViewById(R.id.rv_drinks)
////        rvDrinks.layoutManager= layoutManager
////        rvDrinks.adapter=adapter
//        val intent = Intent(this, choicesActivity::class.java)
//        startActivity(intent)
//    }
//    fun startChoices(){
//        val intent =Intent(this,choicesActivity::class.java)
//        startActivity(intent)
//    }
}
