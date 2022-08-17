package com.example.coffeeapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.coffeeapp.dataClasses.User
import com.example.coffeeapp.network.service
import com.example.example.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
var token:String?=null
class MainActivity : AppCompatActivity() {
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
        val btnRegistration = findViewById<Button>(R.id.btn_register)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        etEmail = findViewById<EditText>(R.id.et_email)
        etPassword = findViewById<EditText>(R.id.et_password)

        btnRegistration.setOnClickListener {
            startRegistration()
        }
        Log.v("1", "before button login")
        btnLogin.setOnClickListener {
            Log.v("2", "inside button login")
            val email = etEmail?.text.toString()
            val password = etPassword?.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "please fill all required fields", Toast.LENGTH_SHORT).show()
            } else {
                val user = User("",email, password)
                service.login(user)
                    .enqueue(object : Callback<LoginResponse> {
                        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>
                        ) {
                            if (response.isSuccessful) {
                                Log.v("3", "onResponse ${response.body().toString()}")
                                token= response.body()?.token
                                startChoices()
                            } else {
                                Log.v("4", "onResponse ${response.code()}")
                            }
                        }

                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Log.v("5", "onFailure ${t.localizedMessage} ")
                        }
                    })

            }
        }

    }
    fun startRegistration() {
        val intent = Intent(this, registrationActivity::class.java)
        startActivity(intent)
    }

    fun startChoices() {
        val intent = Intent(this, choicesActivity::class.java)
        startActivity(intent)
    }
}


