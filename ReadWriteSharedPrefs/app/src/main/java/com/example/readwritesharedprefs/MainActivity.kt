package com.example.readwritesharedprefs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnWrite.setOnClickListener {
            val dataDir= ContextCompat.getDataDir(this)
            val myFile = File(dataDir,"file.txt")
            myFile.writeText(writeText.text.toString())
        }
        btnRead.setOnClickListener {
            val dataDir= ContextCompat.getDataDir(this)
            val myFile = File(dataDir,"file.txt")
            readText.text=myFile.readText()
        }
    }
}