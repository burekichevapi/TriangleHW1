package com.example.trianglehw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import com.example.trianglehw1.fragments.donate_fragment
import com.example.trianglehw1.fragments.startup_fragment
import com.example.trianglehw1.fragments.triangle_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_startup_container.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private val startupFragment: startup_fragment = startup_fragment()
    private val donateFragment: donate_fragment = donate_fragment()
    private val triangleFragment: triangle_fragment = triangle_fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(startupFragment)
        setNavigationBarRoutes()
    }

    fun navigateToTriangleFragment(view: View) {
        setFragment(triangleFragment)
    }

    private fun setNavigationBarRoutes() {
        view_BottomNavBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_startup_nav_button -> setFragment(startupFragment)
                R.id.ic_triangle_nav_button -> setFragment(triangleFragment)
                R.id.ic_donate_nav_button -> setFragment(donateFragment)
                R.id.ic_reset_screen_button -> resetScreen()
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()

        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        transaction.setReorderingAllowed(true)
        transaction.replace(R.id.fragment_container,  fragment)
        transaction.commit()

    }

    private fun resetScreen() {

        //  TODO: insert call to current fragment to reset data to defaults
    }
}

