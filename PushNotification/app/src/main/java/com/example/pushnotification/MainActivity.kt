package com.example.pushnotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Notification Manager
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //channel available post android oreo
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            //Notification Channel
            nm.createNotificationChannel(NotificationChannel("channel"
            ,"Default",NotificationManager.IMPORTANCE_DEFAULT))


            button.setOnClickListener {

                //Notification
                val simpleNotification= NotificationCompat.Builder(this,"channel")
                        .setContentTitle("Simple Notification")
                        .setContentText("This is sample notification")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .build()

                //running notification by notification manager on notification channel
                nm.notify(1,simpleNotification)
            }
            //dynamic broadcast receiver

            val prs =AirplaneModeReceiver()

            val iFilter =IntentFilter().apply {
                addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            }

            registerReceiver(prs,iFilter)
        }



    }

    inner class AirplaneModeReceiver: BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            Toast.makeText(this@MainActivity,"Airplane Mode Changed", Toast.LENGTH_SHORT).show()
        }

    }
}