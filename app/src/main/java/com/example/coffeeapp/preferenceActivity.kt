package com.example.coffeeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeeapp.dataClasses.Drink
import com.example.coffeeapp.dataClasses.SharedList

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
    var size:Int=0
    var sugar:Int=0
    //var quantity = 0
    var hasAllRequiredValues = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        val id=intent.extras?.getInt("id")
        val drink=SharedList.drinks?.find { it.id==id }
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

        drinkName?.text=drink?.name
        coffeePrice?.text= drink?.price.toString()
        Log.v("1", "before button add")
        plusquantity?.setOnClickListener {
            Log.v("2", "inside button add")
                // coffee price
                var basePrice = drink?.price
                quantity++
                displayQuantity()
                val Total = basePrice?.plus(total?.text.toString().toDouble())
                val setnewPrice = Total.toString()
                total?.setText(setnewPrice)

        }

        minusquantity?.setOnClickListener(View.OnClickListener {
            val basePrice = drink?.price
            // because we dont want the quantity go less than 0
            if (quantity == 0) {
                Toast.makeText(this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT)
                    .show()
            } else {
                quantity--
                displayQuantity()
                if(total?.text.toString().toInt()==0){Toast.makeText(this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT)
                    .show()}
                else {
                    val coffePrice = total?.text.toString().toDouble() - basePrice!!
                    val setnewPrice = coffePrice.toString()
                    total?.setText(setnewPrice)
                }
            }
        })

        mediumcup?.setOnClickListener {
            mediumcup?.setBackgroundResource(R.drawable.coffeecupselected)
            smallcup?.setBackgroundResource(R.drawable.coffeecup)
            largecup?.setBackgroundResource(R.drawable.coffeecup)
            coffeePrice?.setText((drink?.price!!+10.0).toString())
            size=1
        }
        largecup?.setOnClickListener {
            largecup?.setBackgroundResource(R.drawable.coffeecupselected)
            smallcup?.setBackgroundResource(R.drawable.coffeecup)
            mediumcup?.setBackgroundResource(R.drawable.coffeecup)
            coffeePrice?.setText((drink?.price!!+15.0).toString())
            size=2
        }
        smallcup?.setOnClickListener {
            smallcup?.setBackgroundResource(R.drawable.coffeecupselected)
            mediumcup?.setBackgroundResource(R.drawable.coffeecup)
            largecup?.setBackgroundResource(R.drawable.coffeecup)
            coffeePrice?.setText((drink?.price!!).toString())
            size=0
        }

        zerosugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcubeselected)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcube)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubes)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubes)
            sugar=0

        }

        onesugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcube)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcubeselected)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubes)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubes)
            sugar=1
        }

        twosugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcube)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcube)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubeselected)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubes)
            sugar=2

        }

        threesugarcube?.setOnClickListener {
            zerosugarcube?.setBackgroundResource(R.drawable.zerosugarcube)
            onesugarcube?.setBackgroundResource(R.drawable.onesugarcube)
            twosugarcube?.setBackgroundResource(R.drawable.twosugarcubes)
            threesugarcube?.setBackgroundResource(R.drawable.threesugarcubeselected)
            sugar=3
        }

        val btnAddToCard = findViewById<Button>(R.id.btn_addToCart)
        btnAddToCard.setOnClickListener{
            SharedList.add(drink!!)
            Log.d("@@@",SharedList.getAllItems().toString())
            Toast.makeText(this,"Successfully Items added in Cart",Toast.LENGTH_SHORT).show()
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