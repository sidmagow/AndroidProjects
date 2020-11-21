package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var note = etNote.text.toString()
        btnDB.setOnClickListener {
           FirebaseDatabase.getInstance().reference.setValue(note)

//            DBRef.setValue(note)
//            Log.d("Test", "onCreate: ${note}")
//            DBRef.child("note").push().setValue(note)
//            DBRef.child("todo").push().setValue(note)
        }
    }
}