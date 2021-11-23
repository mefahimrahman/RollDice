package com.example.rolldice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceFace = dice.roll()
        val diceFaceImage: ImageView = findViewById(R.id.imageView)
        diceFaceImage.setImageResource(R.drawable.dice_5)

        val diceFaceNumberImage = when(diceFace) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceFaceImage.setImageResource(diceFaceNumberImage)

        diceFaceImage.contentDescription = diceFace.toString()
    }
}

class Dice(val numberOfSides: Int) {
    fun roll() = (1..numberOfSides).random()
}