package com.example.lab6correctone

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent?.action == "com.example.Lab6correctone.MY_CUSTOM_ACTION") {
            Toast.makeText(context,"5 seconds passed",Toast.LENGTH_LONG).show()
        }else if (intent?.action == Intent.ACTION_SCREEN_ON) {
            Toast.makeText(context,"Screen On",Toast.LENGTH_LONG).show()
        } else if (intent?.action == Intent.ACTION_SCREEN_OFF) {
        } else if (intent?.action == Intent.ACTION_BATTERY_LOW) {
        }
    }
}