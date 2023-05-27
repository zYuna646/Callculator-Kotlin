package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        val btnNumbers = arrayOf<Button>(
            findViewById(R.id.btnZero),
            findViewById(R.id.btnOne),
            findViewById(R.id.btnTwo),
            findViewById(R.id.btnThree),
            findViewById(R.id.btnFour),
            findViewById(R.id.btnFive),
            findViewById(R.id.btnSix),
            findViewById(R.id.btnSeven),
            findViewById(R.id.btnEight),
            findViewById(R.id.btnNine)
        )

        val btnOperators = arrayOf<Button>(
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnSubtract),
            findViewById(R.id.btnMultiply),
            findViewById(R.id.btnDivide)
        )

        val btnClear: Button = findViewById(R.id.btnClear)
        val btnEqual: Button = findViewById(R.id.btnEqual)
        val btnDot: Button = findViewById(R.id.btnDot)

        for (btnNumber in btnNumbers) {
            btnNumber.setOnClickListener { appendNumber(btnNumber.text) }
        }

        for (btnOperator in btnOperators) {
            btnOperator.setOnClickListener { setOperation(btnOperator.text.toString()) }
        }

        btnClear.setOnClickListener { clear() }

        btnEqual.setOnClickListener { calculate() }

        btnDot.setOnClickListener { appendDot() }
    }

    private fun appendNumber(number: CharSequence) {
        tvResult.append(number)
    }

    private fun appendDot() {
        if (tvResult.text.isEmpty()) {
            tvResult.append("0.")
        } else if (!tvResult.text.contains(".")) {
            tvResult.append(".")
        }
    }

    private fun setOperation(op: String) {
        operand1 = tvResult.text.toString().toDouble()
        operation = op
        tvResult.text = ""
    }

    private fun clear() {
        tvResult.text = ""
        operand1 = 0.0
        operand2 = 0.0
        operation = ""
    }

    private fun calculate() {
        if (tvResult.text.isNotEmpty()) {
            operand2 = tvResult.text.toString().toDouble()
            var result: Double = 0.0

            when (operation) {
                "+" -> result = operand1 + operand2
                "-" -> result = operand1 - operand2
                "*" -> result = operand1 * operand2
                "/" -> result = operand1 / operand2
            }

            tvResult.text = result.toString()
        }
    }

}