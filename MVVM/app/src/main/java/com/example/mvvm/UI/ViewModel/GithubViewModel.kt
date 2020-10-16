package com.example.mvvm.UI.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm.Data.Models.SearchResponse
import com.example.mvvm.Data.Models.User
import com.example.mvvm.Data.Repos.GithubRepository
import kotlinx.coroutines.*

class GithubViewModel:ViewModel() {

    //Live data

    val users=MutableLiveData<List<User>>()
   // val searchUser= MutableLiveData<SearchResponse>()
    //has inbuilt support for coroutines
    fun fetchUsers(){
       Log.d("Testing", "fetchUsers: ")

       viewModelScope.launch(Dispatchers.Main) {
           val response= withContext(Dispatchers.IO){
               GithubRepository.getUsers()
           }
           if(response.isSuccessful){
               val res=response.body()
               Log.d("Test", "${res!![0].login.toString()}")
               response.body().let {
                   users.postValue(it)
               }
           }
       }
    /**       runIo(Dispatchers.Main) {
                val response= withContext(Dispatchers.IO){
                 GithubRepository.getUsers()
                }
                if(response.isSuccessful){
                    val res=response.body()
                    Log.d("Test", "${res!![0].login.toString()}")
                    response.body().let {
                        users.postValue(it)
                    }
                }
            }
       */
    }

    //Method 1 to pass livedata

 /**   fun searchUsers(name:String){
        runIo(Dispatchers.Default) {
            val response= withContext(Dispatchers.IO){
                GithubRepository.searchUsers(name)
            }
            if(response.isSuccessful){
                response.body()?.let {
                   users.postValue(it?.items as List<User>?)
                }
            }
        }
    }  */

    //method 2 to use liveedata
    fun searchUsers(name:String) = liveData<List<User>>(Dispatchers.IO){

            val response= withContext(Dispatchers.IO){
                GithubRepository.searchUsers(name)
            }
            if(response.isSuccessful){
                response.body().let {
                    emit(it?.items as List<User>)
                }
        }
    }

    fun ViewModel.runIo(
        dispatchers:CoroutineDispatcher= Dispatchers.Default,
        function1: suspend CoroutineScope.() -> Unit
    ){
        viewModelScope.launch(dispatchers) {
            function1
        }
    }

}