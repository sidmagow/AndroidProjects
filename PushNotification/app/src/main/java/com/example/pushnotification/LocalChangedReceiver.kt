package com.example.pushnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class LocalChangedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.d("RCV","LOCALE")
        Toast.makeText(context,"Locale Changed",Toast.LENGTH_SHORT).show()
       // context.startActivity(Intent(context,ClickableNotification::class.java))
    }
}
