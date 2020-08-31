package com.example.asynctask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_async_task_class.*
import kotlin.random.Random

var TAG="AsyncTask"
class AsyncTaskClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_class)
        button3.setOnClickListener {
            textView2.text = Random.nextInt(100).toString()
        }
        button2.setOnClickListener {
            var ctest = countTest()

            ctest.execute(5)
        }
    }


    inner class countTest : AsyncTask<Int, Int, Unit>() {
        val ma = MainActivity()
        override fun doInBackground(vararg p0: Int?) {
            var n: Int? = p0[0]
            Log.d(TAG, "doInBackground: Started")

//        if (n != null) {
//            ma.waitNSec(n)
//        }
            // CALLING settext to set the text in thread 1 from thread 2 while running leads to error
            //Only the original thread that created a view hierarchy can touch its views.
//            for (i in 0 until n!! step 1) {
//                ma.wait1Sec()
//                textView2.text=i.toString()
//            }
            for (i in 0 until n!! step 1) {
                ma.wait1Sec()
                publishProgress(i)
           }

            Log.d(TAG, "doInBackground: ended")
           return Unit
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            textView2.text=values[0].toString()
        }



    }

}