package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.example.levelup.R
import com.example.levelup.model.Exercise
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.android.synthetic.main.activity_my_exercises.*
import kotlinx.android.synthetic.main.main_toolbar.*
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Exercises : AppCompatActivity(), View.OnClickListener {

    private val urlEndPoint: URL = URL("http://localhost:8080/api/exercises/all")
    private val myConnection: HttpsURLConnection = urlEndPoint.openConnection() as HttpsURLConnection


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_exercises)
        initMenu()

        if(myConnection.responseCode == 200){
            val responseBody = InputStreamReader(myConnection.inputStream,"UTF-8")
            val mapper = jacksonObjectMapper()
            val allEx = mapper.readValue<List<Exercise>>(urlEndPoint)
        }
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_exercises?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.id_icon_home -> goToActivity(Home::class.java)
                R.id.id_icon_user -> goToActivity(Account::class.java)
                R.id.id_ranking -> goToActivity(Rank::class.java)
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
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        if (drawerLayout_exercises?.isDrawerOpen(Gravity.LEFT)!!) {
            drawerLayout_exercises.closeDrawer(Gravity.LEFT)
        }
    }
}