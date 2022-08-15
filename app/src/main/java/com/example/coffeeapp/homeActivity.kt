package com.example.coffeeapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class homeActivity : AppCompatActivity() {
data class drink(val Name:String,val Price:Double,val imageView: ImageView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val listView=findViewById<ListView>(R.id.listview)
        val drinks = arrayOf("Espresso","Cappuccino","Macciato","Mocha","Latte")
        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,drinks)
        listView.adapter=arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"Item Selected " +drinks[i],Toast.LENGTH_LONG).show()
        }

}
}