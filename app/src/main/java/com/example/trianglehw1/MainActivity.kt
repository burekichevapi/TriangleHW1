package com.example.trianglehw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.trianglehw1.Shapes.ShapeFactory
import com.example.trianglehw1.fragments.donate_fragment
import com.example.trianglehw1.fragments.startup_fragment
import com.example.trianglehw1.fragments.triangle_fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_triangle_container.*
import kotlinx.android.synthetic.main.fragment_triangle_container.view.*

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

    fun determineTriangle(view: View) {

        var i:Int = 0

        val sSides = arrayOf<String>(triangle_fragment.edtTriangleSideA.text.toString(),
            triangle_fragment.edtTriangleSideB.text.toString(),
            triangle_fragment.edtTriangleSideC.text.toString())

        var dSides = arrayOf<Double>(0.0, 0.0, 0.0)

        for (s: String in sSides) {

            if (s.isNullOrBlank()) {
                sendAlert(0)
                return
            }
            dSides.set(i, s.toDouble())
            if (dSides.get(i) <= 0 || dSides.get(i) > 100) {
                sendAlert(1)
                return
            }
            i++
        }

        val tri = ShapeFactory.create(dSides)
            val iImageID = tri.getPictureId()
            triangleFragment.ctrTriangleImage.setImageResource(iImageID)
    }

    fun clearTriangle(view: View?) {
        triangle_fragment.edtTriangleSideA.text.clear()
        triangle_fragment.edtTriangleSideB.text.clear()
        triangle_fragment.edtTriangleSideC.text.clear()
        triangle_fragment.lblTriangleError.setText(R.string.clear_text)
        triangleFragment.ctrTriangleImage.setImageResource(R.drawable.null_shape)

    }

    fun sendAlert(int: Int) {

    //    clearTriangle(null)
        triangleFragment.ctrTriangleImage.setImageResource(R.drawable.invalid_triangle)
        if (int>0) triangle_fragment.lblTriangleError.setText(R.string.invalid_triangle_description)
        else triangle_fragment.lblTriangleError.setText(R.string.null_triangle_description)

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
        clearTriangle(null)
    }
}

