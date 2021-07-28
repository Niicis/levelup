package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.levelup.R
import com.example.levelup.Retrofit.RetrofitInstance
import com.example.levelup.model.Exercise
import com.example.levelup.viewController.adapter.ResponseAdapter
import kotlinx.android.synthetic.main.activity_all_exercises.*
import kotlinx.android.synthetic.main.activity_all_exercises.recycler_excercise
import kotlinx.android.synthetic.main.activity_one_exercise.*
import kotlinx.android.synthetic.main.main_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OneExercise : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_exercise)

        //Recup info d'un exo
        var id_exo = intent.extras?.getString("ID_EX").toString()

        initMenu()
        getOneExe(id_exo)
        getListOfResponse(id_exo)
    }

    private fun getOneExe(id_exo: String) {
        RetrofitInstance.apiExcerciseService.getOneExcercises(id_exo.toInt()).enqueue(object :
            Callback<Exercise> {
            override fun onResponse(call: Call<Exercise>, response: Response<Exercise>) {
                Log.d("body", response.toString())
                if (response.isSuccessful) {
                    Log.d("--- Excercice ---", response.toString())
                    Log.d("--- Excercice ---", response.raw().toString())

                    var exo = response.body()
                    editText_resume?.text = exo?.content

                } else {
                    Log.d("Error Occurred: ", response.message())
                }
            }

            override fun onFailure(call: Call<Exercise>, t: Throwable) {
                Log.d("--- ErrExFragment ---", t.message.toString())
            }
        })
    }

    private fun getListOfResponse(id_exo: String) {
        val responseList = mutableListOf<com.example.levelup.model.Response>()
        recycler_excercise?.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ResponseAdapter(responseList)
        }

        RetrofitInstance.apiResponseService.getResponseByIdEx(id_exo.toInt()).enqueue(object :
            Callback<MutableList<com.example.levelup.model.Response>> {
            override fun onResponse(
                call: Call<MutableList<com.example.levelup.model.Response>>,
                response: Response<MutableList<com.example.levelup.model.Response>>
            ) {
                if (response.isSuccessful) {
                    Log.d("--- Res ---", response.toString())
                    Log.d("--- Res ---", response.raw().toString())

                    response.body()?.let { responseList.addAll(it) }
                    recycler_excercise?.adapter?.notifyDataSetChanged()

                } else {
                    Log.d("Error Occurred: ", response.message())
                }
            }

            override fun onFailure(call: Call<MutableList<com.example.levelup.model.Response>>,t: Throwable) {
                Log.d("--- ErrResFragment ---", t.message.toString())
            }
        })
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_all_exercise?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.id_icon_home -> goToActivity(Account::class.java)
                R.id.id_all_exercises -> goToActivity(AllExercises::class.java)
                R.id.id_icon_logOut -> {
                    goToActivity(MainActivity::class.java)
                }

            }
            true
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            toggle_button -> drawerLayout_all_exercise.openDrawer(Gravity.LEFT)
        }
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        if (drawerLayout_all_exercise?.isDrawerOpen(Gravity.LEFT)!!) {
            drawerLayout_all_exercise.closeDrawer(Gravity.LEFT)
        }
    }
}