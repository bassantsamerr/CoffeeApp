package com.example.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast

import java.util.ArrayList

class homeActivity : AppCompatActivity() {

    private var lv: ListView? = null
    private var customeAdapter: menuAdapter? = null
    private var imageModelArrayList: ArrayList<ImageModel>? = null
    private val myImageList = intArrayOf(R.drawable.cappuccino, R.drawable.espresso, R.drawable.latte, R.drawable.macchiato, R.drawable.mocha)
    private val myImageNameList = arrayOf("Cappuccino", "Espresso", "Latte", "Macchiato", "Mocha")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lv = findViewById(R.id.listView) as ListView

        imageModelArrayList = populateList()
        Log.d("1", imageModelArrayList!!.size.toString() + "")
        customeAdapter = menuAdapter(this, imageModelArrayList!!)
        lv!!.adapter = customeAdapter
        lv!!.setOnItemClickListener { adapterView, view, i, l ->
          //  Toast.makeText(this,"Item Selected " +lv!!.findViewById<TextView>(R.id.name).text.toString(),Toast.LENGTH_LONG).show()
            startPreference()
        }


    }

    private fun populateList(): ArrayList<ImageModel> {

        val list = ArrayList<ImageModel>()

        for (i in 0..4) {
            val imageModel = ImageModel()
            imageModel.setNames(myImageNameList[i])
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }

    fun startPreference(){
        val intent = Intent(this,preferenceActivity::class.java)
        startActivity(intent)
    }
}