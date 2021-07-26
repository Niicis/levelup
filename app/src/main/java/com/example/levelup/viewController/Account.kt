package com.example.levelup.viewController

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.example.levelup.*
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.main_toolbar.*

class Account : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        initMenu()
    }

    private fun initMenu() {
        toggle_button?.setOnClickListener(this)
        navigationView_account?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.id_icon_home -> goToActivity(Home::class.java)
                //R.id.id_icon_user -> goToActivity(Account::class.java)

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