package com.example.retrofittest.api

import com.example.retrofittest.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPostSpecific(
        @Path("postNumber") number :Int ):Response<Post>


    @GET("posts")
    suspend fun getCustomPost(
         @Query("userId") userId:Int,
         @Query("_sort") sort:String,
         @Query("_order") order:String
    ):Response<List<Post>>

    @GET("posts")
    suspend fun getCustomMapPost(
        @Query("userId") userId:Int,
        @QueryMap options: Map<String,String>
    ):Response<List<Post>>


    @POST("posts")
     suspend fun pushPost(
       @Body post:Post
    ): Response<Post>

    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPostUrlEncoded(
        @Field("userId") userId:Int,
        @Field("id") id:Int,
        @Field("title") title:String,
        @Field("body") body:String
    ): Response<Post>

}