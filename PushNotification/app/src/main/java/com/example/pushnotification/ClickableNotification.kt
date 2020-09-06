package com.example.pushnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_clickable_notification.*

class ClickableNotification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clickable_notification)

        //Notification Manager
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //channel available post android oreo
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //Notification Channel
            nm.createNotificationChannel(
                NotificationChannel(
                    "channel1"
                    , "Default", NotificationManager.IMPORTANCE_DEFAULT
                )
            )
        } 

        button2.setOnClickListener {
            val i=Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.com")

            val pi=PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)
            val ClickableNotification= NotificationCompat.Builder(this,"channel")
                .setContentTitle("Simple Notification")
                .addAction(R.drawable.ic_launcher_foreground,"Click Me",pi)
                //.setContentIntent(pi)
                .setAutoCancel(true)
                .setContentText("This is sample notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(2,ClickableNotification)
        }
    }
}