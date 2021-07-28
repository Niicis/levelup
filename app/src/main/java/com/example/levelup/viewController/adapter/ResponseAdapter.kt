package com.example.levelup.viewController.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.levelup.model.Exercise
import com.example.levelup.model.Response
import com.example.levelup.viewController.ViewHolder.ExcerciseViewHolder
import com.example.levelup.viewController.ViewHolder.ResponseViewHolder

class ResponseAdapter (private val dataSet: MutableList<Response>): RecyclerView.Adapter<ResponseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder
    {
        val itemView = LayoutInflater.from(parent.context)
        return ResponseViewHolder(itemView, parent)
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int)
    {
        val car: Response = dataSet[position]
        holder.bind(car)
    }

    override fun getItemCount(): Int = dataSet.size

}