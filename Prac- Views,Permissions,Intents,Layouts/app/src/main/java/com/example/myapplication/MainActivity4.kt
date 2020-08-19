package com.example.myapplication

import android.Manifest
import android.Manifest.*
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main4.*


class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        button.setOnClickListener {
            var perm=ContextCompat.checkSelfPermission(this, permission.CALL_PHONE)
            if(perm==PackageManager.PERMISSION_GRANTED){
                callNumber()
            }
            else{
                ActivityCompat.requestPermissions(this,Array<String>(1){ permission.CALL_PHONE},121)
            }
        }



    }

    fun callNumber(){
        var x=textView4.text
        var i=Intent()
        i.action=Intent.ACTION_CALL
        i.data= Uri.parse("tel:$x")
        startActivity(i)
    }
}