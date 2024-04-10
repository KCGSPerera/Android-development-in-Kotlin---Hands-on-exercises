package com.example.labexampracticetute7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView:TextView = findViewById(R.id.textView)
        val button:Button = findViewById(R.id.button)

        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        textView.text = viewModel.count.value.toString()

        button.setOnClickListener{

            viewModel.increment()
        }

        viewModel.count.observe(this){

            textView.text = it.toString()
        }
    }
}