package com.example.sqliteandtodoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todoitem.view.*

class CustomAdapter(val todolist:ArrayList<Todo>,val itemClickListener:SwitchListener):RecyclerView.Adapter<CustomAdapter.todoViewHolder>(){

// class CustomAdapter(val todolist:ArrayList<Todo>):RecyclerView.Adapter<CustomAdapter.todoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.todoitem,parent,false)
        return todoViewHolder(itemView)
    }

    override fun getItemCount(): Int = todolist.size

    override fun onBindViewHolder(holder: todoViewHolder, position: Int) {
        holder.apply {
            bind(position,itemClickListener)
           // bind(position)
        }

    }

   inner class todoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       fun bind(position:Int,onitemClicked:SwitchListener){
   // fun bind(position:Int){
           itemView.textView1.text = todolist[position].task
           itemView.switch1.isChecked= todolist[position].done
           itemView.switch1.setOnClickListener {
               onitemClicked.onItemClicked2(position,!todolist[position].done)
           }
       }
   }

}



