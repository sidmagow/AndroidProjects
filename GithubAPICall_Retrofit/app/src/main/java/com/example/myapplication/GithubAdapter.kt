package com.example.myapplication

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout.view.*

class GithubAdapter(private val users:ArrayList<GithubUser>): RecyclerView.Adapter<GithubAdapter.GithubViewHolder>(){
    constructor() : this(ArrayList<GithubUser>())

    var x=0

    var onItemClicked:((id:String)->Unit)? = null


//    fun onitemClicked1(id1:String){
//        val i=Intent(,UserActivity::class.java)
//        i.putExtra(id1,false)
//
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder =
        GithubViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false))

    override fun getItemCount()= users.size

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
            holder.bind(position)
//            holder.itemView.textView1.text=users[position].login
//            holder.itemView.textView2.text=users[position].score.toString()
//            holder.itemView.textView3.text=users[position].html_url
//            Picasso.get().load(users[position].avatar_url).into(holder.itemView.imageview);


    }

    inner class GithubViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        fun bind(pos:Int){
            itemView.apply {

                textView1.text=users[pos].login
                textView2.text=users[pos].score.toString()
                textView3.text=users[pos].html_url
                Picasso.get().load(users[pos].avatar_url).into(itemView.imageview);
                setOnClickListener {
                    Log.d("bindit", "bind: ${it.textView1.text}")
                    onItemClicked?.invoke(users[pos].login)
                }
            }

        }

    }

}

