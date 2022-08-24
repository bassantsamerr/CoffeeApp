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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class registrationActivity : AppCompatActivity() {
    var etEmail: EditText? = null
    var etUsername: EditText? = null
    var etPassword: EditText? = null
    var etRepeatedPass: EditText? = null
    var btnSignUp: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etEmail = findViewById<EditText>(R.id.et_regEmail)
        etUsername = findViewById<EditText>(R.id.et_regUsername)
        etPassword = findViewById<EditText>(R.id.et_regPassword)
        etRepeatedPass = findViewById<EditText>(R.id.et_regRepeatPassword)
        btnSignUp = findViewById(R.id.btn_SignUP)


        Log.v("1", "before button register")
        btnSignUp?.setOnClickListener {
            Log.v("2", "inside button register")
            val email = etEmail?.text.toString()
            val password = etPassword?.text.toString()
            val username = etUsername?.text.toString()
            val repeatedPass = etRepeatedPass?.text.toString()
            if(email.isEmpty() || password.isEmpty() || username.isEmpty() || repeatedPass.isEmpty()){
                Toast.makeText(this,"please fill all required fields", Toast.LENGTH_SHORT).show()
            }else if(password != repeatedPass){
                Toast.makeText(this,"password field is not equal to repeated password field", Toast.LENGTH_SHORT).show()
            }else{
                val user = User(username, password,email)
                service.signup(user)
//                    .enqueue(object : Callback<Unit> {
//                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
//                            if (response.isSuccessful) {
//                                //Toast.makeText(this@RegisterActivity,"please fill all required fields", Toast.LENGTH_SHORT).show()
//
//                                Log.v("3", "onResponse ${response.body().toString()}")
//                                startSignUp()
//
//                            } else {
//                                Log.v("4", "onResponse ${response.code()}")
//                            }
//                        }
//
//                        override fun onFailure(call: Call<Unit>, t: Throwable) {
//                            Log.v("5", "onFailure ${t.localizedMessage} ")
//                        }
//                    })
                startSignUp()
                                }}




//
//        val btnSignUp = findViewById<Button>(R.id.btn_SignUP)
//        btnSignUp.setOnClickListener{
//            startSignUp()
//    }

    }
        fun startSignUp(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
}