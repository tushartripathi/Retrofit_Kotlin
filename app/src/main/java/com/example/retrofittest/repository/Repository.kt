package com.example.retrofittest.repository

import com.example.retrofittest.api.RetrofitInstance
import com.example.retrofittest.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPostSpecific(number : Int) : Response<Post> {
        return RetrofitInstance.api.getPostSpecific(number)
    }

    suspend fun getCustomPost(userId : Int,sort:String, order:String) : Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }
    suspend fun getCustomMapPost(userId : Int,options:Map<String,String>) : Response<List<Post>> {
        return RetrofitInstance.api.getCustomMapPost(userId,options)
    }

    suspend fun pushPost(post : Post) : Response<Post>
    {
        return  RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPostUrl(userId: Int,id:Int,title:String, body:String) : Response<Post>
    {
        return  RetrofitInstance.api.pushPostUrlEncoded(userId,id, title, body)
    }


}