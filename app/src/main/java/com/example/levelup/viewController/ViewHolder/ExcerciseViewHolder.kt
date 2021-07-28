package com.example.levelup.viewController.ViewHolder

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.levelup.R
import com.example.levelup.model.Exercise
import com.example.levelup.viewController.OneExercise

class ExcerciseViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.excercise_item, parent, false)
    )
{
    private var item_id: TextView? = null
    private var item_title: TextView? = null
    private var item_content: TextView? = null

    init
    {
        item_id = itemView.findViewById(R.id.ex_id_item)
        item_title = itemView.findViewById(R.id.ex_title_item)
        item_content = itemView.findViewById(R.id.ex_content_item)
    }

    fun bind(ex: Exercise)
    {
        item_id?.text  = ex.id
        item_title?.text  = ex.title
        item_content?.text  = ex.content

        itemView.setOnClickListener {
            val result = ex.id
            val exIntent = Intent(it.context, OneExercise::class.java)
                .putExtra("ID_EX", result)
            it.context.startActivity(exIntent)
        }
    }
}