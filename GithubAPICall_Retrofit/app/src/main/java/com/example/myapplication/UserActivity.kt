package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.layout.*
import kotlinx.android.synthetic.main.layout.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        val idOfUser=intent.getStringExtra(KEY1)
        GlobalScope.launch(Dispatchers.Main) {


            val response= withContext(Dispatchers.IO){
                Client1.api.getUserById(idOfUser)
                // Client1.api.searchUsers(username.text.toString())
            }

            //Log.d("Retrofit", "networkCallUsingRetrofit: ${response} ")
            if(response.isSuccessful){
                val res=response.body().let {

                    textView1.text=it!!.login
                    textView2.text=it!!.avatar_url
                    textView3.text=it!!.html_url
                    Picasso.get().load(it!!.avatar_url).into(imageview);

                }

            }

        }


    }
}