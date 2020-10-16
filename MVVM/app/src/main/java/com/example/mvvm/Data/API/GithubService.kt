package com.example.mvvm.Data.API

import com.example.mvvm.Data.Models.SearchResponse
import com.example.mvvm.Data.Models.User
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>


    @GET("search/users")
    suspend fun searchUser(@Query("q") name: String): Response<SearchResponse>
}