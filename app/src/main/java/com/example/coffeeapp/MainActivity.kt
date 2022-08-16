package com.example.coffeeapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()
        val btnRegistration = findViewById<Button>(R.id.btn_register)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnRegistration.setOnClickListener{
            startRegistration()
        }
        btnLogin.setOnClickListener{
            startChoices()
        }
    }
    fun startRegistration(){
        val intent =Intent(this,registrationActivity::class.java)
        startActivity(intent)
    }
    fun startChoices(){
        val intent =Intent(this,choicesActivity::class.java)
        startActivity(intent)
    }
}