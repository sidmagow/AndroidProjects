package com.example.mvvm.Data.Repos

import com.example.mvvm.Data.API.Client

object GithubRepository  {

    suspend fun getUsers() = Client.api.getUsers()

    suspend fun searchUsers(name:String) = Client.api.searchUser(name)
}