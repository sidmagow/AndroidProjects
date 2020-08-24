package com.example.listview_gradeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout11.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lvFruits.adapter=ArrayAdapter<String>(this,R.layout.layout11,R.id.list_item_fruit, arrayOf(
            "Apple",
            "Mango",
            "Banana",
            "Kiwi",
            "Strawberry",
            "Papaya",
            "Watermelon",
            "Grapes"
        ))

       lvFruits.setOnItemClickListener { adapterView, view, i, l ->
           Toast.makeText(this,
               "Johnny ate ${i+1} ${view.list_item_fruit.text}",
               Toast.LENGTH_SHORT).show()
       }
    }
}