package com.example.levelup.viewController.ViewHolder

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.levelup.R
import com.example.levelup.model.Comment
import com.example.levelup.model.Exercise

class CommentViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.comment_item, parent, false)
    )
{
    private var com_id_item: TextView? = null
    private var com_user_item: TextView? = null
    private var com_date_item: TextView? = null
    private var com_content_item: TextView? = null

    init
    {
        com_id_item = itemView.findViewById(R.id.com_id_item)
        com_user_item = itemView.findViewById(R.id.com_user_item)
        com_date_item = itemView.findViewById(R.id.com_date_item)
        com_content_item = itemView.findViewById(R.id.com_content_item)
    }

    fun bind(com: Comment)
    {
        com_id_item?.text  = com.id
        com_user_item?.text  = com.userid.toString()
        com_date_item?.text  = com.date.toString()
        com_content_item?.text  = com.content

    }
}