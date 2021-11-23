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
        val diceNumber: TextView = findViewById(R.id.diceFaceNumber)
        diceNumber.text = dice.roll().toString()
        Toast.makeText(this, "Tapped", Toast.LENGTH_SHORT).show()
    }
}

class Dice(val numberOfSides: Int) {
    fun roll() = (1..numberOfSides).random()
}