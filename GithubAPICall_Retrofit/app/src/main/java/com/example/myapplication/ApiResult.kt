package com.example.myapplication

data class ApiResult(val total_count:Int,val incomplete_results:Boolean, val items:ArrayList<GithubUser>){
    constructor() : this(-1,false,ArrayList<GithubUser>())


}