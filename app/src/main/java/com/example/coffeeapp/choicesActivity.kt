package com.example.coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class choicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choices)
        val btnProfile = findViewById<Button>(R.id.btn_profile)
        btnProfile.setOnClickListener{
            startProfile()
        }
        val btnMenu = findViewById<Button>(R.id.btn_menu)
        btnMenu.setOnClickListener{
            startMenu()
        }
        val btnViewCard = findViewById<Button>(R.id.btn_viewCard)
        btnViewCard.setOnClickListener{
            startViewCard()
        }
    }
    fun startProfile(){
        val intent = Intent(this,profileActivity::class.java)
        startActivity(intent)
    }
    fun startMenu(){
        val intent =Intent(this,ListActivity::class.java)
        startActivity(intent)
    }
    fun startViewCard(){
        val intent =Intent(this,viewCartActivity::class.java)
        startActivity(intent)
    }

}