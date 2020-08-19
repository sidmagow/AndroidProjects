package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity3 : AppCompatActivity() {
     val TAG="Implicit Intent"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var textfield:String

        textView.setOnClickListener {
            val i=Intent()
            i.action=Intent.ACTION_SENDTO
            textfield=textView3.text.toString()
            Log.i(TAG, " $textfield ")
            i.data= Uri.parse("mail to : $textfield")
            //i.putExtra(Intent.EXTRA_SUBJECT, "Implicit Intents")
            startActivity(i)
        }
        ImplicitIntentBtn.setOnClickListener {

            val i=Intent()
            i.action=Intent.ACTION_DIAL
            textfield=textView3.text.toString()
            i.data= Uri.parse("tel:$textfield")
            startActivity(i)
        }
        ImplicitIntentBtn1.setOnClickListener {


            val i=Intent()
            i.action=Intent.ACTION_VIEW
            textfield=textView3.text.toString()
            i.data= Uri.parse("http://$textfield")
            startActivity(i)

        }
    }







    fun toast(view: View) {
        Toast.makeText(this, "Switching Intent", Toast.LENGTH_SHORT).show()
        val i = Intent(this, MainActivity::class.java )
        startActivity(i)
    }
}