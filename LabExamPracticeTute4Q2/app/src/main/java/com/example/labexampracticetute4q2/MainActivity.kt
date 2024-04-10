package com.example.labexampracticetute4q2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edtName:EditText
    lateinit var btnWelcme:Button
    lateinit var btnGoodBye:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)
        btnWelcme = findViewById(R.id.btnWelcome)
        btnGoodBye = findViewById(R.id.btnGoodBye)


        btnWelcme.setOnClickListener(){

            welcome()
        }

        btnGoodBye.setOnClickListener(){
            goodBye()
        }
    }

    fun welcome(){
        Toast.makeText(this,"${getText((R.string.msg1))} ${edtName.text.toString()}", Toast.LENGTH_LONG).show()
    }

    fun goodBye(){
        Toast.makeText(this,"${getText(R.string.msg2 )} ${edtName.text.toString()}", Toast.LENGTH_LONG).show()

    }

}