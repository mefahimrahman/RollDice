package com.example.rolldice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDiceClicked() }
    }

    private fun rollDiceClicked() {
        val dice = Dice(6)
        val diceFace = dice.roll()
        val diceNumber: TextView = findViewById(R.id.diceFaceNumber)
        diceNumber.text = diceFace.toString()
        when (diceFace) {
            5 -> displayLuckyNumberToast()
            1, 2, 3, 4, 6 -> displayTryAgainToast()
        }
    }

    private fun displayTryAgainToast() {
        Toast.makeText(this, "Ops!! Try Again", Toast.LENGTH_SHORT).show()
    }

    private fun displayLuckyNumberToast() {
        Toast.makeText(this, "Yeee!! Lucky Number!!", Toast.LENGTH_SHORT).show()
    }
}

class Dice(val numberOfSides: Int) {
    fun roll() = (1..numberOfSides).random()
}