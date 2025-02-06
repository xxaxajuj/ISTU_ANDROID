package com.example.beeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBeer = findViewById<Button>(R.id.find_beer)
        val beerColor = findViewById<Spinner>(R.id.beer_color)
        val brands = findViewById<TextView>(R.id.brands)
        val image1 = findViewById<ImageView>(R.id.imageView3)
        val image2 = findViewById<ImageView>(R.id.imageView4)

        findBeer.setOnClickListener {
            val color = beerColor.selectedItem
            val beerList = getBeers(color.toString())
            val beers = beerList.reduce { str, item -> str + '\n' + item }
            brands.text = beers
            testupdateimage(color.toString(), image1, image2)
        }
    }


    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            "Amber beer" -> listOf("Red ale", "Vienna lager")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }

    fun testupdateimage(color: String, image1: ImageView, image2: ImageView) {
        when (color) {
            "Light" -> {
                image1.setImageResource(R.drawable.dark)
                image2.setImageResource(R.drawable.ale)
            }

            "Amber" -> {
                image1.setImageResource(R.drawable.amberale)
                image2.setImageResource(R.drawable.beer)
            }
        }
    }
}