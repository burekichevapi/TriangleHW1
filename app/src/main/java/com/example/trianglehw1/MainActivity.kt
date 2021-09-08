package com.example.trianglehw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.trianglehw1.fragments.donate_fragment
import com.example.trianglehw1.fragments.startup_fragment
import com.example.trianglehw1.fragments.triangle_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val startupFragment: startup_fragment = startup_fragment()
    private val donateFragment: donate_fragment = donate_fragment()
    private val triangleFragment: triangle_fragment = triangle_fragment()

    //  changed

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){

            R.id.ic_back_nav_button -> transaction.replace(R.id.fragment_container, startupFragment)
            R.id.ic_reset_screen_button -> transaction.replace(R.id.fragment_container, triangleFragment)
            R.id.ic_donate_nav_button -> transaction.replace(R.id.fragment_container, donateFragment)
        }
        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,  startupFragment)
        transaction.commit()

        // TEST COMMENT
    }
}