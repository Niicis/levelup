package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.levelup.*
import com.example.levelup.Preferences.AppPreferences
import com.example.levelup.Retrofit.RetrofitInstance
import com.example.levelup.model.Exercise
import com.example.levelup.viewController.adapter.ExcerciseAdapter
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.android.synthetic.main.activity_all_exercises.*
import kotlinx.android.synthetic.main.main_toolbar.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStreamReader

class AllExercises : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_exercises)
        initMenu()

        val excercises = mutableListOf<Exercise>()
        recycler_excercise?.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ExcerciseAdapter(excercises)
        }

        RetrofitInstance.apiExcerciseService.getExcercises().enqueue(object : Callback<MutableList<Exercise>> {
            override fun onResponse(call: Call<MutableList<Exercise>>, response: Response<MutableList<Exercise>>) {
                Log.d("body", response.toString())
                if(response.isSuccessful) {
                    Log.d("--- Excercice ---", response.toString())
                    Log.d("--- Excercice ---", response.raw().toString())

                    Log.d("body", response.toString())
                    response.body()?.let { excercises.addAll(it) }
                    recycler_excercise?.adapter?.notifyDataSetChanged()

                } else {
                    Log.d( "Error Occurred: ", response.message())
                }
            }

            override fun onFailure(call: Call<MutableList<Exercise>>, t: Throwable) {
                Log.d("--- ErrExFragment ---", t.message.toString())
            }
        })
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_all_exercise?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.id_icon_user -> goToActivity(Account::class.java)
                R.id.id_exercises -> goToActivity(Exercises::class.java)
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