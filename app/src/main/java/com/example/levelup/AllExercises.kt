package com.example.levelup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_my_exercises.*
import kotlinx.android.synthetic.main.main_toolbar.*

class AllExercises : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_exercises)
        initMenu()
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_exercises?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.id_icon_home -> goToActivity(MainActivity::class.java)
                R.id.id_icon_user -> goToActivity(Account::class.java)

                R.id.id_ranking -> goToActivity(Rank::class.java)
                R.id.id_exercises -> goToActivity(Exercises::class.java)
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