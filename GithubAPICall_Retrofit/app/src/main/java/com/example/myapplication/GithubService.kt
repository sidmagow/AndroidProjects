package com.example.myapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    suspend fun getUsers(): Response<ArrayList<GithubUser>>

    @GET("users/{id}")
    suspend fun getUserById(@Path(value = "id")id:String): Response<GithubUser>

    @GET("search/users")
    suspend fun searchUsers(@Query(value = "q")query:String): Response<ApiResult>
}