package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.example.levelup.*
import com.example.levelup.model.Exercise
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.android.synthetic.main.activity_all_exercises.*
import kotlinx.android.synthetic.main.main_toolbar.*
import java.io.InputStreamReader

class AllExercises : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_exercises)
        initMenu()
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_all_exercise?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.id_icon_home -> goToActivity(Home::class.java)
                R.id.id_icon_user -> goToActivity(Account::class.java)

                R.id.id_ranking -> goToActivity(Rank::class.java)
                R.id.id_exercises -> goToActivity(Exercises::class.java)
                //R.id.id_all_exercises -> goToActivity(AllExercises::class.java)
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