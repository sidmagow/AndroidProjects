package com.example.sqliteandtodoapp

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log

object TodoTable {
    val TABLE_NAME = "todos"
    object columns{
        val ID = "id"
        val TASK = "task"
        val DONE = "done"
    }
    val CMD_CREATE_TABLE = """         
         CREATE TABLE IF NOT EXISTS $TABLE_NAME
         (
         ${columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
         ${columns.TASK} TEXT,
         ${columns.DONE} BOOLEAN
         );
    """.trimIndent()

    fun insertTodo(db:SQLiteDatabase,todo:Todo){
        val row=ContentValues()
        row.put(columns.TASK,todo.task)
        row.put(columns.DONE,todo.done)
        try {
            db.insert(TABLE_NAME, null, row)
        }catch ( e:SQLiteException){
            Log.d("SQLException", "There has been a SQL exception")
        }
    }

    fun getAllTodos(db:SQLiteDatabase):ArrayList<Todo>{
        var todos=ArrayList<Todo>()
        var c =db.query(TABLE_NAME, arrayOf(columns.ID,columns.TASK,columns.DONE),null,null,null,null,null)

        while (c.moveToNext()){
            val todo = Todo(c.getString(1),c.getInt(2)==1)
            todos.add(todo)
        }
        return todos
    }

    fun updateTodo(db: SQLiteDatabase,id:Int,b:Boolean){
       val cv=ContentValues()
        cv.put(columns.DONE,b)
        db.update(TABLE_NAME,cv,"${columns.ID}="+id,null)
        Log.d("UPDATE", "updated")
    }
}