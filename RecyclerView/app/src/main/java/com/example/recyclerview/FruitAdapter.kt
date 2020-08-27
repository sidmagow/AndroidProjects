package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout.view.*

class FruitAdapter(val fruits:ArrayList<Fruit>): RecyclerView.Adapter<FruitAdapter.FruitViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false)
        return FruitViewHolder(itemView)
    }

    override fun getItemCount(): Int = fruits.size

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.itemView.textView1.text=fruits[position].name
        holder.itemView.textView2.text=fruits[position].origin
        holder.itemView.textView3.text=fruits[position].quantity.toString()

    }



    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
