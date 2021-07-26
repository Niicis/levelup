package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.levelup.R
import com.example.levelup.model.Exercise
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.android.synthetic.main.activity_log_in.*
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val urlEndPoint: URL = URL("http://localhost:8080/api/auth/login")
    private val myConnection = urlEndPoint.openConnection() as HttpsURLConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        /*myConnection.setRequestProperty("email",editText_login.text.toString())
        myConnection.setRequestProperty("password",editText_password.text.toString())

        if(myConnection.responseCode == 200){
            val responseBody = InputStreamReader(myConnection.inputStream,"UTF-8")
            val mapper = jacksonObjectMapper()
            val allEx = mapper.readValue<List<Exercise>>(urlEndPoint)
        }*/


        goToActivity(Home::class.java)
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}