package com.example.levelup.viewController.ViewHolder

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.levelup.R
import com.example.levelup.Retrofit.RetrofitInstance
import com.example.levelup.model.Comment
import com.example.levelup.model.Exercise
import com.example.levelup.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
        com_id_item?.text  = com.id.toString()
        com_user_item?.text

        getOneUser(com.userid)

        var convertedDate = SimpleDateFormat("dd MMM yyyy")
        com_date_item?.text  = convertedDate.format(com.date).toString()
        com_content_item?.text  = com.content

    }

    private fun getOneUser(id_use: Int) {
        RetrofitInstance.apiUserService.getUsersById(id_use).enqueue(object :
            Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("body", response.toString())
                if (response.isSuccessful) {

                    var user = response.body()
                    com_user_item?.text = user?.username

                } else {
                    Log.d("Error Occurred: ", response.message())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("--- ErrExFragment ---", t.message.toString())
            }
        })
    }
}