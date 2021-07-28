package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import com.example.levelup.*
import com.example.levelup.viewController.Preferences.AppPreferences
import com.example.levelup.Retrofit.RetrofitInstance
import com.example.levelup.model.auth.Login
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.main_toolbar.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Account : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        initMenu()

        RetrofitInstance.apiUserService.getUser(Login(AppPreferences.email.toString(),AppPreferences.password.toString())).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful) {
                    Log.d("--- LoginFragment ---", response.toString())
                    Log.d("--- LoginFragment ---", response.raw().toString())

                    val token = response.headers().get("Authorization")

                    if (token != null) {
                        Log.d("--- LoginFragment ---", token)
                    }

                    //mettre l'user

                } else {
                    Log.d( "Error Occurred: ", response.message())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("--- ErrLogFragment ---", t.message.toString())
            }
        })
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_account?.setNavigationItemSelectedListener {
            when (it.itemId) {
                //R.id.id_icon_home -> goToActivity(Account::class.java)
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
            toggle_button -> drawerLayout_account.openDrawer(Gravity.LEFT)
        }
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        if (drawerLayout_account?.isDrawerOpen(Gravity.LEFT)!!) {
            drawerLayout_account.closeDrawer(Gravity.LEFT)
        }
    }
}