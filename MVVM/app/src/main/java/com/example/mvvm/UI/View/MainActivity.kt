package com.example.mvvm.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.Data.Models.User
import com.example.mvvm.R
import com.example.mvvm.UI.Adapter.GithubUserAdapter
import com.example.mvvm.UI.ViewModel.GithubViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val vm by lazy {
        ViewModelProvider(this).get(GithubViewModel::class.java)
    }

    val list = arrayListOf<User>()
    val originalList = arrayListOf<User>()
    val adapter = GithubUserAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.fetchUsers()

        with(rvUsers){
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=this@MainActivity.adapter
        }
        svUser.isSubmitButtonEnabled= true
        svUser.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                findUser(p0)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                findUser(p0)
                return true
            }

        })

        svUser.setOnCloseListener {
            list.clear()
            list.addAll(originalList)
            adapter.notifyDataSetChanged()
            return@setOnCloseListener true
        }

        vm.users.observe(this, Observer {
            if(!it.isNullOrEmpty()){
                list.addAll(it)
                originalList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

    }

    private fun findUser(query: String?) {
        vm.searchUsers(query!!).observe(this, Observer {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

}