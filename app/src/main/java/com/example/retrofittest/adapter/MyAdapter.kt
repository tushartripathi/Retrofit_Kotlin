package com.example.retrofittest.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittest.R
import com.example.retrofittest.model.Post

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var userIDTextView :TextView
        var idTextView :TextView
        var titleextView :TextView
        var bodyTextView :TextView
        init {
            userIDTextView =  itemView.findViewById(R.id.userId_ID)
            idTextView =  itemView.findViewById(R.id.id_ID)
            titleextView =  itemView.findViewById(R.id.title_ID)
            bodyTextView =  itemView.findViewById(R.id.body_ID)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent,false))
    }

    override fun getItemCount(): Int {
       return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userIDTextView.setText(myList.get(position).userId.toString())
        holder.idTextView.setText(myList.get(position).id.toString())
        holder.titleextView.setText(myList.get(position).title.toString())
        holder.bodyTextView.setText(myList.get(position).body.toString())
    }

    fun setData(newList : List<Post>)
    {
        myList = newList
        notifyDataSetChanged()
    }
}