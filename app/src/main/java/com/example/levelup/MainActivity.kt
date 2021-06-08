package com.example.levelup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_toolbar.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
        initMenu()
    }

    private fun initListener() {
        login_login_button.setOnClickListener(this)
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_main?.setNavigationItemSelectedListener {
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
            toggle_button -> drawerLayout_main.openDrawer(Gravity.LEFT)
            login_login_button -> checkAccount()
        }
    }

    private fun checkAccount() {
        //appel a l'api pour connection
        goToActivity(Rank::class.java)
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        if (drawerLayout_main?.isDrawerOpen(Gravity.LEFT)!!) {
            drawerLayout_main.closeDrawer(Gravity.LEFT)
        }
    }
}