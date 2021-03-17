package com.example.retrofittest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.model.Post
import com.example.retrofittest.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseSpecific :  MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPost : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomMapPost : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response : Response<Post>? = repository.getPost()
            myResponse.value =response
        }
    }

    fun getPostSpecific(num : Int) {
        viewModelScope.launch {
            val repponse : Response<Post>? = repository.getPostSpecific(num)
            myResponseSpecific.value = repponse

        }
    }

    fun getCustomPosts(userId:Int,sort:String,order:String) {
        viewModelScope.launch {
            val response : Response<List<Post>>? = repository.getCustomPost(userId,sort,order)
            myCustomPost.value = response
        }
    }

    fun getCustomMapPosts(userId:Int, options:Map<String,String>) {
        viewModelScope.launch {
            val response : Response<List<Post>>? = repository.getCustomMapPost(userId,options)
            myCustomMapPost.value = response
        }
    }

    fun pushPost(post : Post)
    {
        viewModelScope.launch {
            val response : Response<Post> = repository.pushPost(post)
            myResponse.value = response

        }
    }

    fun pushPostUrl(userId: Int,id:Int,title:String, body:String)
    {
        viewModelScope.launch {
            val response : Response<Post> = repository.pushPostUrl(userId,id, title, body)
            myResponse.value = response

        }
    }
}