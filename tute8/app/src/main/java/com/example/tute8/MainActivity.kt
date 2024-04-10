package com.example.tute8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val homeFragment = HomeFragment()
    val settingsfragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val button2 : Button = findViewById(R.id.button)


        button2.setOnClickListener{

        }
        button.setOnClickListener{

        }

    }

    private fun loadHome(){

        val fragment = supportFragmentManager
            .findFragmentById(R.id.containerFragment)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.containerFragment,homeFragment).commit()
        }
        else{
            supportFragmentManager.beginTransaction().add(R.id.containerFragment,homeFragment).commit()
        }
    }

    private fun loadSettings(){

        val fragment = supportFragmentManager.findFragmentById(R.id.containerFragment)
    }
}