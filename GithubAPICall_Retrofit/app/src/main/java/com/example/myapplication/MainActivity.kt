package com.example.myapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

const val KEY1="sendid"

class MainActivity : AppCompatActivity() {

    var gitAdapter=GithubAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dd=DownloadData()





        btn.setOnClickListener {
            //Network call using async
            //dd.execute("https://api.github.com/search/users?q=${username.text.toString()}")

            //network call using okhttp
            //networkCall("https://api.github.com/search/users?q=${username.text.toString()}")

             networkCallUsingRetrofit()


        }

    }

    //using Retrofit and GSON Adapter
    fun networkCallUsingRetrofit (){

        Log.d("Test", "onCreate: SAB SAHI H")
        GlobalScope.launch(Dispatchers.Main) {


            val response= withContext(Dispatchers.IO){
                Client1.api.searchUsers(username.text.toString())
                // Client1.api.searchUsers(username.text.toString())
            }

            Log.d("Retrofit", "networkCallUsingRetrofit: ${response} ")
            if(response.isSuccessful){
                val res=response.body().let {
                    gitAdapter = GithubAdapter(it!!.items)

                }


            }

        }
        gitAdapter.onItemClicked={
            val i=Intent(this,UserActivity::class.java)
            i.putExtra(KEY1,it)
            startActivity(i)
        }
        showGithubUsers.layoutManager= LinearLayoutManager(baseContext)
        showGithubUsers.adapter=gitAdapter

    }

    //using OKHTTP and GSON
    fun networkCall(url:String){
        var client= OkHttpClient()

        var request= Request.Builder()
            .url(url)
            .build()

       // synchronous network call using okhttp on main thread
      //  var response=client.newCall(request).execute()

        //asynchronous

         val call= client.newCall(request)
        call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            //is not running on ui thread
            override fun onResponse(call: Call, response: Response) {

                var result= response.body()?.string()
               val gson:Gson= Gson()
                val apiResult:ApiResult = gson.fromJson(result,ApiResult::class.java)
                
                //using GSON
                val users= apiResult.items
                    
                //using parse json function
                //var users:ArrayList<GithubUser> = ParseJson(result)


                runOnUiThread(Runnable {
                    val gitAdapter=GithubAdapter(users)
                    showGithubUsers.layoutManager= LinearLayoutManager(baseContext)
                    showGithubUsers.adapter=gitAdapter
                })
            }

        })


    }

    fun ParseJson(result: String?):ArrayList<GithubUser>{
        var users: ArrayList<GithubUser> = ArrayList<GithubUser>()

        //parse json
        var root:JSONObject= JSONObject(result)
        var items:JSONArray=root.getJSONArray("items")
        for(i in 0 until items.length()){
            var jsonObject:JSONObject = items[i] as JSONObject
            var login=jsonObject.getString("login")
            Log.d("Testing", "Login : ${login}")
            var id=jsonObject.getInt("id")
            var avatar=jsonObject.getString("avatar_url")
            var score=jsonObject.getDouble("score")
            var html=jsonObject.getString("html_url")

            var user=GithubUser(login,id,html,score,avatar)

            users.add(user)
        }

        return users
    }

    inner class DownloadData: AsyncTask<String, Unit, String>() {
        override fun doInBackground(vararg p0: String?): String {
            var stringUrl =p0[0]


            try {
                val url = URL(stringUrl)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                val inputStream1 = httpURLConnection.inputStream
                val scanner = Scanner(inputStream1)
                scanner.useDelimiter("\\A")

                while (scanner.hasNext()) {
                    return scanner.next()
                }
            }catch (e:Exception){
                e.printStackTrace()
            }



            return "Failed to Load"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            var users:ArrayList<GithubUser> = ParseJson(result)

          //  Log.d("MainActivity", "No. of users ${users.size}")
            val gitAdapter=GithubAdapter(users)

            //Layout Manager not understood

            showGithubUsers.layoutManager= LinearLayoutManager(baseContext)
            showGithubUsers.adapter=gitAdapter
           // showText.text=result
        }
    }


}

