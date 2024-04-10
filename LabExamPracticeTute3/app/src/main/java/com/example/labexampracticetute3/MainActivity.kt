package com.example.labexampracticetute3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.labexampracticetute3.Models.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var edtNumber1:EditText
    lateinit var edtNumber2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
    }

    fun buttonClick(v:View){

        var ans = 0.0

        var calculator = Calculator(
            edtNumber1.text.toString().toDouble(),
            edtNumber2.text.toString().toDouble()
        )

        when(v.id){

            R.id.btnAdd -> ans = calculator.add()
            R.id.btnSubstract -> ans = calculator.substract()
            R.id.btnMultiply -> ans = calculator.multiply()
            R.id.btnDevide -> ans = calculator.devide()
        }

        Toast.makeText(this,"Answer = $ans", Toast.LENGTH_LONG).show()
    }
}