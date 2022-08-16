package com.example.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
var total:TextView? = null
var quantity = 0
class preferenceActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var plusquantity: ImageButton? = null
    var minusquantity:ImageButton? = null
    var quantitynumber: TextView? = null
    var drinkName:TextView? = null
    //var total:TextView? = null
    var coffeePrice:TextView?=null
    var addtoCart: Button? = null
    var mediumcup:ImageButton?=null
    var smallcup:ImageButton?=null
    var largecup:ImageButton?=null
    var zerosugarcube:ImageButton?=null
    var onesugarcube:ImageButton?=null
    var twosugarcube:ImageButton?=null
    var threesugarcube:ImageButton?=null
    //var quantity = 0
    var hasAllRequiredValues = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        imageView = findViewById(R.id.imageViewInfo)
        plusquantity = findViewById(R.id.addquantity)
        minusquantity  = findViewById(R.id.subquantity)
        quantitynumber = findViewById(R.id.quantity)
        drinkName = findViewById(R.id.drinkNameinInfo)
        total = findViewById(R.id.total)
        addtoCart = findViewById(R.id.btn_addToCart)
        coffeePrice=findViewById(R.id.coffeePrice)
        mediumcup=findViewById(R.id.medium_cup)
        smallcup=findViewById(R.id.small_cup)
        largecup=findViewById(R.id.large_cup)
        zerosugarcube=findViewById(R.id.zerosugarcube)
        onesugarcube=findViewById(R.id.onesugarcube)
        twosugarcube=findViewById(R.id.twosugarcube)
        threesugarcube=findViewById(R.id.threesugarcube)


        Log.v("1", "before button add")
        plusquantity?.setOnClickListener {
            Log.v("2", "inside button add")
                // coffee price
                var basePrice = coffeePrice?.text.toString().toInt()
                quantity++
                displayQuantity()
                val Total = basePrice + total?.text.toString().toInt()
                val setnewPrice = Total.toString()
                total?.setText(setnewPrice)

        }

        minusquantity?.setOnClickListener(View.OnClickListener {
            val basePrice = coffeePrice?.text.toString().toInt()
            // because we dont want the quantity go less than 0
            if (quantity == 0) {
                Toast.makeText(this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT)
                    .show()
            } else {
                quantity--
                displayQuantity()
                val coffePrice =total?.text.toString().toInt()- basePrice
                val setnewPrice = coffePrice.toString()
                total?.setText(setnewPrice)

            }
        })

        mediumcup?.setOnClickListener {
            mediumcup?.setBackgroundResource(R.drawable.coffeecupselected)
            smallcup?.setBackgroundResource(R.drawable.coffeecup)
            largecup?.setBackgroundResource(R.drawable.coffeecup)
            coffeePrice?.setText("40")
        }
        largecup?.setOnClickListener {
            largecup?.setBackgroundResource(R.drawable.coffeecupselected)
            smallcup?.setBackgroundResource(R.drawable.coffeecup)
            mediumcup?.setBackgroundResource(R.drawable.coffeecup)
            coffeePrice?.setText("50")
        }
        smallcup?.setOnClickListener {
            smallcup?.setBackgroundResource(R.drawable.coffeecupselected)
            mediumcup?.setBackgroundResource(R.drawable.coffeecup)
            largecup?.setBackgroundResource(R.drawable.coffeecup)
            coffeePrice?.setText("30")
        }

        zerosugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcubeselected)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcube)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubes)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubes)

        }

        onesugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcube)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcubeselected)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubes)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubes)

        }

        twosugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcube)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcube)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubeselected)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubes)

        }

        threesugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcube)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcube)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubes)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubeselected)

        }

        val btnAddToCard = findViewById<Button>(R.id.btn_addToCart)
        btnAddToCard.setOnClickListener{
            startChoices()
        }
    }
    fun startChoices(){
        val intent =Intent(this,choicesActivity::class.java)
        startActivity(intent)
    }
    private fun displayQuantity() {
        quantitynumber!!.text = quantity.toString()
    }

}