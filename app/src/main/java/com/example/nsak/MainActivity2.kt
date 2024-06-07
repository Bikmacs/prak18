package com.example.nsak

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val nextButton = findViewById<Button>(R.id.neext)
        nextButton.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        // EditTexts
        val incomeEditText = findViewById<EditText>(R.id.incomeEditText)
        val expensesEditText = findViewById<EditText>(R.id.expensesEditText)
        val taxRateEditText = findViewById<EditText>(R.id.taxRateEditText)

        // Button
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            val income = incomeEditText.text.toString().toDoubleOrNull() ?: 0.0
            val expenses = expensesEditText.text.toString().toDoubleOrNull() ?: 0.0
            val taxRate = taxRateEditText.text.toString().toDoubleOrNull() ?: 0.0

            val tax = (income - expenses) * taxRate / 100
            val resultTextView = findViewById<TextView>(R.id.resultTextView)
            resultTextView.text = "Результат: $tax"
        }
    }
}
