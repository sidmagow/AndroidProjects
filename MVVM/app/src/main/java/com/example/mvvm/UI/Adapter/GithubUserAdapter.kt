package com.example.mvvm.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.Data.Models.User
import com.example.mvvm.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class GithubUserAdapter(val users:List<User>) :RecyclerView.Adapter<GithubUserAdapter.GithubViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return  GithubViewHolder(itemView)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(users[position])
    }

    class GithubViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bind(item:User) = with(itemView){
            tvName.text=item.login
            Picasso.get().load(item.avatarUrl).into(imageView)
        }
    }
}

