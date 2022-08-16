package com.example.coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class preferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        val btnAddToCard = findViewById<Button>(R.id.btn_addToCart)
        btnAddToCard.setOnClickListener{
            startHome()
        }
    }
    fun startHome(){
        val intent =Intent(this,homeActivity::class.java)
        startActivity(intent)
    }
}