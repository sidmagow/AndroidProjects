package com.example.sqliteandtodoapp

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SwitchListener{
//class MainActivity : AppCompatActivity(){
    var todos=ArrayList<Todo>()
    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        db=MyDBHelper(this).writableDatabase
        val todoAdapter= CustomAdapter(todos,this)

      //  val todoAdapter= CustomAdapter(todos)

        fun refreshLayout(){
            val newlist = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(newlist)

            todoAdapter.notifyDataSetChanged()
        }
        viewTodo.layoutManager= LinearLayoutManager(this)
        viewTodo.adapter=todoAdapter
        refreshLayout()

        addTodo.setOnClickListener {
            val newTodo=Todo(enterTodo.text.toString(),false)
            TodoTable.insertTodo(db,newTodo)
            refreshLayout()
        }


    }

    override fun onItemClicked2(pos:Int,b:Boolean) {
        val id=pos+1
        TodoTable.updateTodo(db,id,b)
    }


}