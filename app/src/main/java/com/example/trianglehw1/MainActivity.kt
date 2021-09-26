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

class MainActivity : AppCompatActivity() {

    private val startupFragment: startup_fragment = startup_fragment()
    private val donateFragment: donate_fragment = donate_fragment()
    private val triangleFragment: triangle_fragment = triangle_fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNavigationBarRoutes()
        setFragment(startupFragment)
    }

    fun determineTriangle(view: View) {

        val inputs = arrayOf(
            triangleFragment.edtTriangleSideA.text.toString(),
            triangleFragment.edtTriangleSideB.text.toString(),
            triangleFragment.edtTriangleSideC.text.toString()
        )

        val sides = getValidSides(inputs)
        val factory = ShapeFactory(sides)
        val shape = factory.create()

        triangleFragment.ctrTriangleImage.setImageResource(shape.getPictureId())
        triangleFragment.lblTriangleError.text = resources.getString(shape.getDescriptionId())
    }

    fun navigateToTriangleFragment(view: View) {
        setFragment(triangleFragment)
    }

    fun clearTriangle(view: View) {
        if(triangleFragment.isVisible) {
            triangleFragment.edtTriangleSideA.text.clear()
            triangleFragment.edtTriangleSideB.text.clear()
            triangleFragment.edtTriangleSideC.text.clear()
            triangleFragment.lblTriangleError.setText(R.string.clear_text)
            triangleFragment.ctrTriangleImage.setImageResource(0)
        }

    }

    private fun getValidSides(inputs: Array<String>) :Array<Double> {
        val sides: ArrayList<Double> = arrayListOf()
        inputs.forEach {
            if (!it.isNullOrEmpty()) {
                val side = it.toDouble()
                if (side <= 100.0)
                    sides.add(side)
            }
        }

        return sides.toDoubleArray().toTypedArray()
    }

    private fun setNavigationBarRoutes() {
        view_BottomNavBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_startup_nav_button -> setFragment(startupFragment)
                R.id.ic_triangle_nav_button -> setFragment(triangleFragment)
                R.id.ic_donate_nav_button -> setFragment(donateFragment)
                R.id.ic_reset_screen_button -> clearTriangle(this.view_Main)
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
}

