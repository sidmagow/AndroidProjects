package com.example.asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

public open class MainActivity : AppCompatActivity() {
    val TAG="Async"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {

            //working on the main ui thread. leading to frozen screen.
           // waitNSec(5)

            var h:Handler= Handler();
            var r:Runnable= Runnable {
                fun run(){
                    Toast.makeText(it.context, "Waited 5 sec", Toast.LENGTH_SHORT).show()
                }
                run()
            }
            h.postDelayed(r,5000)
        }
    }


    fun wait1Sec(){
        var startTime=System.currentTimeMillis()
        while(System.currentTimeMillis()<startTime+1000){}
    }
    public fun waitNSec(n:Int){
        for(i in 1..n){
            wait1Sec()
        }
    }


}
