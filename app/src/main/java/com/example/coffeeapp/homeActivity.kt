//package com.example.coffeeapp
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.ListView
//import androidx.appcompat.app.AppCompatActivity
//import android.util.Log
//import android.widget.TextView
//import android.widget.Toast
//import com.example.coffeeapp.dataClasses.Drink
//import com.example.coffeeapp.network.service
//import com.example.example.LoginResponse
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//import java.util.ArrayList
//
//class homeActivity : AppCompatActivity() {
//
//    private var lv: ListView? = null
//    private var customeAdapter: menuAdapter? = null
//    private var imageModelArrayList: ArrayList<ImageModel>? = null
//    private val myImageList = intArrayOf(
//        R.drawable.cappuccino,
//        R.drawable.espresso,
//        R.drawable.latte,
//        R.drawable.macchiato,
//        R.drawable.mocha
//    )
//    private val myImageNameList = arrayOf("Cappuccino", "Espresso", "Latte", "Macchiato", "Mocha")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//
//        lv = findViewById(R.id.listView) as ListView
//
//        // imageModelArrayList = populateList()
//        //Log.d("1", imageModelArrayList!!.size.toString() + "")
//        //customeAdapter = menuAdapter(this, imageModelArrayList!!)
//        //lv!!.adapter = customeAdapter
//        service.getAllProducts(token).enqueue(object : Callback<List<Drink>> {
//            override fun onResponse(call: Call<List<Drink>>, response: Response<List<Drink>>) {
//                if (response.isSuccessful) {
//                    Log.v("3", "onResponse ${response.body().toString()}")
//                    menuAdapter()
//                    startPreference()
//                    //notifyDatasetChanged()
//
//                } else {
//                    Log.v("4", "onResponse ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Drink>>, t: Throwable) {
//                Log.v("5", "onFailure ${t.localizedMessage} ")
//            }
//        })
//
//
//
//
//
////    private fun populateList(): ArrayList<ImageModel> {
////
////        val list = ArrayList<ImageModel>()
////
////        for (i in 0..4) {
////            val imageModel = ImageModel()
////            imageModel.setNames(myImageNameList[i])
////            imageModel.setImage_drawables(myImageList[i])
////            list.add(imageModel)
////        }
////
////        return list
////    }
//    }
//
//    fun startPreference() {
//        val intent = Intent(this, preferenceActivity::class.java)
//        startActivity(intent)
//    }
//}
