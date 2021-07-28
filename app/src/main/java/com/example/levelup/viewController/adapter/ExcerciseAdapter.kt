package com.example.levelup.viewController.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.levelup.R
import com.example.levelup.model.Exercise
import com.example.levelup.viewController.ViewHolder.ExcerciseViewHolder

class ExcerciseAdapter(private val dataSet: MutableList<Exercise>): RecyclerView.Adapter<ExcerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcerciseViewHolder
    {
        val itemView = LayoutInflater.from(parent.context)
        return ExcerciseViewHolder(itemView, parent)
    }

    override fun onBindViewHolder(holder: ExcerciseViewHolder, position: Int)
    {
        val car: Exercise = dataSet[position]
        holder.bind(car)
    }

    override fun getItemCount(): Int = dataSet.size

    }