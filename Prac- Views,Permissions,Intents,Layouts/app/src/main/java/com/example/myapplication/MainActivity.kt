package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_main.*

const val KEY_I = "name"
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var EditTextValue: String

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //val textv=findViewById<TextView>(R.id.btn1)

        //access/change xml view properties
        //scope functions in kotlin

        editText.apply {
            hint="enter name"

      //      isEnabled="False"
            addTextChangedListener {
                Log.i("ViewBinding",it.toString())
                if(it.toString().length>10){
                    Log.i("Length Changed", it.toString())
                }
            }





        }
        //view binding in kotlin method 1
        btn2.setOnClickListener{
            Log.i("Button","Button Clicked")
            Toast.makeText(it.context,"Buttton pressed through listener",Toast.LENGTH_SHORT).show()
        }
        //view binding in kotlin method 2
        btn2.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View) {
                Toast.makeText(p0.context,"Buttton pressed through interface",Toast.LENGTH_SHORT).show()
            }

        })
        //view binding in kotlin method 2
        btn2.setOnClickListener(this)

        //explicit intent and sending data using explicit intent
        IntentBtn.setOnClickListener {
            val i = Intent(this,MainActivity2::class.java)
            EditTextValue= ExplicitIntent.text.toString()
            i.putExtra(KEY_I,EditTextValue)
            Log.i(TAG, "value of edittext : $EditTextValue")

            startActivity(i)

        }

        //Normal Permissions
        Perm.setOnClickListener {
            var cm:ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var netInfo:NetworkInfo? = cm.activeNetworkInfo
            var isConnected:Boolean= netInfo != null && netInfo.isConnected
            permview.text = isConnected.toString()
        }

        //dynamic permissions
        dangerPerms.setOnClickListener {
            val i=Intent(this,MainActivity4::class.java)
            startActivity(i)
        }



        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {
        print("Hello World")
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }


    fun toast1(view: View){

        Toast.makeText(view.context , "Button Text Changed", Toast.LENGTH_SHORT).show()
        btn1.text="Siddhant"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    companion object {
        const val TAG = "ActivityLfcy"
    }

    override fun onClick(p0: View) {
        Toast.makeText(p0.context , "Button Text Changed through 3rd functio", Toast.LENGTH_SHORT).show()
    }
}