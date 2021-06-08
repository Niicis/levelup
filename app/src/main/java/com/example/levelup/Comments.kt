package com.example.levelup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_my_exercises.*

class Comments : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        initMenu()
    }

    private fun initMenu() {
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_list -> goToActivity(Exercises::class.java)
                //R.id.ic_map -> goToActivity(Comments::class.java)
            }
            true
        }
    }

    private fun goToActivity(destination: Class<*>) {
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}