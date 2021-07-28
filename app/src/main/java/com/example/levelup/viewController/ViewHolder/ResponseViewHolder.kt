package com.example.levelup.viewController.ViewHolder

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.levelup.R
import com.example.levelup.Retrofit.RetrofitInstance
import com.example.levelup.model.Exercise
import com.example.levelup.model.Response
import com.example.levelup.viewController.Exercises
import kotlinx.android.synthetic.main.activity_one_exercise.*
import retrofit2.Call
import retrofit2.Callback

class ResponseViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.response_item, parent, false)
    )
{
    private var res_id_item: TextView? = null
    private var res_ex_item: TextView? = null
    private var res_status_item: TextView? = null
    private var res_date_item: TextView? = null

    init
    {
        res_id_item = itemView.findViewById(R.id.res_id_item)
        res_ex_item = itemView.findViewById(R.id.res_ex_item)
        res_status_item = itemView.findViewById(R.id.res_status_item)
        res_date_item = itemView.findViewById(R.id.res_date_item)
    }

    fun bind(res: Response)
    {
        res_id_item?.text  = res.id.toString()
        getOneExe(res.exerciseid.toString())

        res_status_item?.text  = res.status.toString()
        res_date_item?.text  = res.date.toString()


        itemView.setOnClickListener {
            val result = res.id
            val exItent = Intent(it.context, Exercises::class.java)
                .putExtra("ID_RES", result)
            it.context.startActivity(exItent)
        }
    }

    private fun getOneExe(id_exo: String) {
        RetrofitInstance.apiExcerciseService.getOneExcercises(id_exo.toInt()).enqueue(object :
            Callback<Exercise> {
            override fun onResponse(call: Call<Exercise>, response: retrofit2.Response<Exercise>) {
                Log.d("body", response.toString())
                if (response.isSuccessful) {
                    Log.d("--- Excercice ---", response.toString())
                    Log.d("--- Excercice ---", response.raw().toString())

                    var exo = response.body()
                    res_ex_item?.text = exo?.title

                } else {
                    Log.d("Error Occurred: ", response.message())
                }
            }

            override fun onFailure(call: Call<Exercise>, t: Throwable) {
                Log.d("--- ErrExFragment ---", t.message.toString())
            }
        })
    }
}