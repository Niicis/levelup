package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.levelup.R
import com.example.levelup.Retrofit.RetrofitInstance
import com.example.levelup.model.Comment
import com.example.levelup.model.Exercise
import com.example.levelup.viewController.adapter.CommentAdapter
import com.example.levelup.viewController.adapter.ExcerciseAdapter
import kotlinx.android.synthetic.main.activity_all_exercises.*
import kotlinx.android.synthetic.main.activity_all_exercises.recycler_excercise
import kotlinx.android.synthetic.main.activity_comments.*
import kotlinx.android.synthetic.main.activity_my_exercises.*
import kotlinx.android.synthetic.main.activity_my_exercises.bottom_navigation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Comments : AppCompatActivity(), View.OnClickListener {
    private var id_res: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        id_res = intent.extras?.getInt("ID_RES")
        initMenu()

        getComment(id_res)
    }

    private fun getComment(id_res: Int?) {
        val comment = mutableListOf<Comment>()
        recycler_coment?.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = CommentAdapter(comment)
        }

        if (id_res != null) {
            RetrofitInstance.apiComentService.getComment(id_res).enqueue(object : Callback<MutableList<Comment>> {
                override fun onResponse(
                    call: Call<MutableList<Comment>>,
                    response: Response<MutableList<Comment>>
                ) {
                    Log.d("body", response.toString())
                    if (response.isSuccessful) {
                        Log.d("--- Comment ---", response.toString())
                        Log.d("--- Comment ---", response.raw().toString())

                        Log.d("body", response.toString())
                        response.body()?.let { comment.addAll(it) }
                        recycler_coment?.adapter?.notifyDataSetChanged()

                    } else {
                        Log.d("Error Occurred: ", response.message())
                    }
                }

                override fun onFailure(call: Call<MutableList<Comment>>, t: Throwable) {
                    Log.d("--- ErrComFragment ---", t.message.toString())
                }
            })
        }
    }

    private fun initMenu() {
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_list -> goToActivity(Exercises::class.java)
                //R.id.ic_map -> goToActivity(Comments::class.java)
            }
            true
        }
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination).putExtra("ID_RES",id_res))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}