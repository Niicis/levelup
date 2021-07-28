package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import com.example.levelup.R
import com.example.levelup.Retrofit.RetrofitInstance
import kotlinx.android.synthetic.main.activity_my_exercises.*
import kotlinx.android.synthetic.main.main_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Exercises : AppCompatActivity(), View.OnClickListener {

    private var id_res: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_exercises)
        initMenu()
        id_res = intent.extras?.getInt("ID_RES")

        if (id_res != null) {
            RetrofitInstance.apiResponseService.getReponseById(id_res!!).enqueue(object : Callback<com.example.levelup.model.Response> {
                override fun onResponse(call: Call<com.example.levelup.model.Response>, response: Response<com.example.levelup.model.Response>) {
                    Log.d("body", response.toString())
                    if(response.isSuccessful) {
                        Log.d("--- Excercice ---", response.toString())
                        Log.d("--- Excercice ---", response.raw().toString())

                        Log.d("body", response.toString())
                        var res = response.body()
                        editText_resume.text = res?.status
                        txt_answer.text = res?.codeSent
                        id_res = res?.id
                    } else {
                        Log.d( "Error Occurred: ", response.message())
                    }
                }

                override fun onFailure(call: Call<com.example.levelup.model.Response>, t: Throwable) {
                    Log.d("--- ErrExFragment ---", t.message.toString())
                }
            })
        }

    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_exercises?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.id_icon_user -> goToActivity(Account::class.java)
               // R.id.id_exercises -> goToActivity(Exercises::class.java)
                R.id.id_all_exercises -> goToActivity(AllExercises::class.java)
                R.id.id_icon_logOut -> {
                    goToActivity(MainActivity::class.java)
                }

            }
            true
        }

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                //R.id.ic_list -> goToActivity(Exercises::class.java)
                R.id.ic_map -> goToActivity(Comments::class.java)
            }
            true
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            toggle_button -> drawerLayout_exercises.openDrawer(Gravity.LEFT)
        }
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination).putExtra("ID_RES",id_res))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        if (drawerLayout_exercises?.isDrawerOpen(Gravity.LEFT)!!) {
            drawerLayout_exercises.closeDrawer(Gravity.LEFT)
        }
    }
}