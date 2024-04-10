package com.example.lab_03

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creating the button to navigate

        val btnNavigate: Button = findViewById(R.id.btnNavigate)
        btnNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // MainActivity.kt
        val btnSendData: Button = findViewById(R.id.btnSendData)
        val editTextName: EditText = findViewById(R.id.EditText)
        btnSendData.setOnClickListener {
            val name = editTextName.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER_NAME", name)
            startActivity(intent)
        }

        // task 3
        val btnOpenWeb: Button = findViewById(R.id.btnOpenWeb)
        btnOpenWeb.setOnClickListener {
            val webpage = Uri.parse("http://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
          //  if (intent.resolveActivity(packageManager) != null) {
          //      startActivity(intent)
         //   }

            try {
                startActivity(intent)
            }catch (ex: ActivityNotFoundException){
                print("Not found")
            }
        }

        // Dialer
        val btnDialPhone: Button = findViewById(R.id.btnDialPhone)
        btnDialPhone.setOnClickListener {
            val phoneUri = Uri.parse("tel:1234567890")
            val intent = Intent(Intent.ACTION_DIAL, phoneUri)


           // if (intent.resolveActivity(packageManager) != null) {
           //     startActivity(intent)
          //  }

            try {
                startActivity(intent)
            }catch (ex: ActivityNotFoundException){
                print("Not found")
            }
        }


        // camera

        val btnCapturePhoto: Button = findViewById(R.id.btnCapturePhoto)
        btnCapturePhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
           // if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
           // }
        }



    }
}