package com.example.customadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout.*


class MainActivity : AppCompatActivity() {
    var teachers:ArrayList<Teacher> = Teacher.getTeacher()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var teacherAdapter:TeacherAdapter= TeacherAdapter()
        lvTeachers.adapter=teacherAdapter


    }

    inner class TeacherAdapter: BaseAdapter() {
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var itemView:View=layoutInflater.inflate(R.layout.layout,p2,false)
            var tvName:TextView=itemView.findViewById(R.id.textView1)
            var tvCourse:TextView=itemView.findViewById(R.id.textView2)
            tvName.text=getItem(p0).name
            tvCourse.text=getItem(p0).course
            return itemView
        }

        override fun getItem(p0: Int): Teacher {

            return teachers[p0]
        }

        override fun getItemId(p0: Int): Long {
                    return 0;

        }

        override fun getCount(): Int {

            return teachers.size
        }

    }

}