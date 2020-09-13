package com.example.readwritesharedprefs

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPref : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        val sPref= getPreferences(Context.MODE_PRIVATE)
        val col = sPref.getInt("COLOR", Color.WHITE)
        llBackground.setBackgroundColor(col)

        fun saveColor(color:Int){
            var editor = sPref.edit()
            editor.putInt("COLOR",color)
            editor.apply()
        }

        Red.setOnClickListener {
            llBackground.setBackgroundColor(Color.RED)
            saveColor(Color.RED)
        }
        Blue.setOnClickListener {
            llBackground.setBackgroundColor(Color.BLUE)
            saveColor(Color.BLUE)
        }
        Green.setOnClickListener {
            llBackground.setBackgroundColor(Color.GREEN)
            saveColor(Color.GREEN)
        }

    }
}