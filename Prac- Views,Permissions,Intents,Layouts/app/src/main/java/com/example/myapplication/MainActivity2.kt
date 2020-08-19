package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    //const val KEY_I = "name"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        IntentBtn1.setOnClickListener {
            var i= Intent(this, MainActivity3::class.java)

            //getting intent and the value
            var name = intent.getStringExtra(KEY_I)
            Log.i("Text Received in Intent", " $name ")
            Toast.makeText(it.context, "Data Received through Intent is $name", Toast.LENGTH_LONG).show()
            startActivity(i)
        }
    }
}