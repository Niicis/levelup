package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.levelup.Preferences.AppPreferences
import com.example.levelup.R
import com.example.levelup.Retrofit.RetrofitInstance
import com.example.levelup.model.auth.Login
import kotlinx.android.synthetic.main.activity_log_in.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppPreferences.setup(applicationContext)
        setContentView(R.layout.activity_log_in)

        initListener()
    }

    private fun initListener() {
        login_login_button.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        when (view) {
            login_login_button -> checkAccount()
        }
    }

    private fun checkAccount() {
        var login = Login(editText_login.text.toString(),editText_password.text.toString())
        Log.d("--- Login ---", login.email.toString())
        Log.d("--- Login ---", login.password.toString())

        RetrofitInstance.apiAuthService.login(login).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful) {
                    Log.d("--- LoginFragment ---", response.toString())
                    Log.d("--- LoginFragment ---", response.raw().toString())

                    val token = response.headers().get("Authorization")

                    if (token != null) {
                        Log.d("--- LoginFragment ---", token)
                    }

                    AppPreferences.token = token
                    AppPreferences.email = login.email
                    AppPreferences.password = login.password

                    goToActivity(AllExercises::class.java)
                } else {
                    Log.d( "Error Occurred: ", response.message())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("--- ErrLogFragment ---", t.message.toString())
            }
        })

        //goToActivity(Home::class.java)
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}