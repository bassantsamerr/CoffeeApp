package com.example.coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class registrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val btnSignUp = findViewById<Button>(R.id.btn_SignUP)
        btnSignUp.setOnClickListener{
            startSignUp()
    }
    }
        fun startSignUp(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
}