package com.example.pushnotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_heads_up_notification.*

class headsUpNotification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heads_up_notification)

        val nm= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel= NotificationChannel("headsUp","Headsup Notif Channel", NotificationManager.IMPORTANCE_HIGH)
            channel.apply {
                enableLights(true)
                enableVibration(true)
            }
            nm.createNotificationChannel(channel)

        }

        button3.setOnClickListener {
           val builder = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
               Notification.Builder(this,"headsUp")

           }
           else{
               Notification.Builder(this)
                   .setPriority(Notification.PRIORITY_MAX)
                   .setDefaults(Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS or Notification.DEFAULT_SOUND)
           }

            val headsUpNotif = builder
                .setContentTitle("HeadsUp Notification")
                .setContentText("Look here i am!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build()

            nm.notify(3,headsUpNotif)

        }



    }
}