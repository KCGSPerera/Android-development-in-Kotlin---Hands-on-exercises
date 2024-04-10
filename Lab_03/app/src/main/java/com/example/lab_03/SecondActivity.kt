package com.example.lab_03

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)

        // SecondActivity.kt
        val textViewGreeting: TextView = findViewById(R.id.textView)
        val intent = intent
        val name = intent.getStringExtra("USER_NAME")
        textViewGreeting.text = "Hello, $name!"

    }

}