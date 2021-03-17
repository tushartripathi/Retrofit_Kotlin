package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittest.adapter.MyAdapter
import com.example.retrofittest.model.Post
import com.example.retrofittest.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var myAdapter: MyAdapter
    lateinit var myRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)
        myAdapter = MyAdapter()
        setUpRecyclerView()
        val repository = Repository()
        val viewModelFactory=ViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        var myPost = Post(1,2,"tittle is this","this project is for testing.....")
      //  viewModel.pushPost(myPost)
     //   viewModel.pushPostUrl(2,2,"hello world fdgfdg","Body value")
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response->

            if(response.isSuccessful)
            {
                Toast.makeText(this,response.body()?.title.toString(),Toast.LENGTH_SHORT).show()
                Log.d("TAG",response.body().toString())
                Log.d("TAG",response.code().toString())
                Log.d("TAG",response.headers().toString())

            }
            else
            { Toast.makeText(this,response.code(),Toast.LENGTH_SHORT).show() }
        })
    }

    private fun setUpRecyclerView()
    {
        myRecyclerView.adapter = myAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}

