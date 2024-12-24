package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var resultText: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        weightInput = findViewById(R.id.weightInput)
        heightInput = findViewById(R.id.heightInput)
        resultText = findViewById(R.id.resultText)
        calculateButton = findViewById(R.id.calculateButton)

        // Set up click listener for the button
        calculateButton.setOnClickListener {
            // Get user inputs
            val weight = weightInput.text.toString()
            val height = heightInput.text.toString()

            // Validate inputs
            if (weight.isEmpty() || height.isEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter valid inputs", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Convert input strings to numeric values
            val weightValue = weight.toDouble()
            val heightValue = height.toDouble()

            // Calculate BMI
            val bmi = weightValue / (heightValue * heightValue)

            // Display BMI result
            var resultMessage = "BMI: %.2f".format(bmi)
            resultMessage += when {
                bmi < 18.5 -> " - Underweight"
                bmi in 18.5..24.9 -> " - Normal weight"
                bmi in 25.0..29.9 -> " - Overweight"
                else -> " - Obesity"
            }

            resultText.text = resultMessage
        }
    }
}
