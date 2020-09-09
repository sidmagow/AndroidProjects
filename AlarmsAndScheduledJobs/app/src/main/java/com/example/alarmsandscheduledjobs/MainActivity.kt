package com.example.alarmsandscheduledjobs

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            val i= Intent(baseContext,MainActivity2::class.java)

            val pi=PendingIntent.getActivity(baseContext,12345,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val am= getSystemService(Context.ALARM_SERVICE) as AlarmManager

          //  am.set(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+60000,pi)
        

            //repeating alarm

            am.setRepeating(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+60000,45000,pi)
        }
    }
}