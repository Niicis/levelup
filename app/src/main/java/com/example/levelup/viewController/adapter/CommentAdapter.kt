package com.example.levelup.viewController.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.levelup.model.Comment
import com.example.levelup.model.Exercise
import com.example.levelup.viewController.ViewHolder.CommentViewHolder
import com.example.levelup.viewController.ViewHolder.ExcerciseViewHolder

class CommentAdapter (private val dataSet: MutableList<Comment>): RecyclerView.Adapter<CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder
    {
        val itemView = LayoutInflater.from(parent.context)
        return CommentViewHolder(itemView, parent)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int)
    {
        val comment: Comment = dataSet[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int = dataSet.size

}