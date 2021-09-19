package com.example.trianglehw1

import android.graphics.drawable.shapes.Shape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.trianglehw1.Shapes.Shape
import com.example.trianglehw1.Shapes.ShapeFactory
import com.example.trianglehw1.fragments.donate_fragment
import com.example.trianglehw1.fragments.startup_fragment
import com.example.trianglehw1.fragments.triangle_fragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.trianglehw1.Shapes.ShapeFactory
import com.example.trianglehw1.Shapes.Triangles.Triangle
import kotlinx.android.synthetic.main.fragment_donate_container.*
import kotlinx.android.synthetic.main.fragment_triangle_container.*
import kotlinx.android.synthetic.main.fragment_triangle_container.view.*
import kotlinx.coroutines.suspendAtomicCancellableCoroutine
import javax.xml.transform.OutputKeys


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

        val sSideA: String = triangle_fragment.edtTriangleSideA.text.toString()
        if (sSideA.isNullOrBlank()) {
            sendAlert(0)
            return
        }
        val dSideA: Double = sSideA.toDouble()
        if (dSideA <= 0 || dSideA > 100) {
            sendAlert(1)
            return
        }

        val sSideB: String = triangle_fragment.edtTriangleSideB.text.toString()
        if (sSideB.isNullOrBlank()) {
            sendAlert(0)
            return
        }
        val dSideB: Double = sSideB.toDouble()
        if (dSideB <= 0 || dSideB > 100) {
            sendAlert(1)
            return
        }

        val sSideC: String = triangle_fragment.edtTriangleSideC.text.toString()
        if (sSideC.isNullOrBlank()) {
            sendAlert(0)
            return
        }
        val dSideC: Double = sSideC.toDouble()
        if (dSideC <= 0 || dSideC > 100) {
            sendAlert(1)
            return
        }

        val tri = ShapeFactory.create(arrayOf(dSideA, dSideB, dSideC))
        if (tri is Result.Ok ) {
            val iImageID = tri.value.getPictureId()
            triangleFragment.ctrTriangleImage.setImageResource(iImageID)
        }

    }

    fun clearTriangle(view: View) {
        triangle_fragment.edtTriangleSideA.text.clear()
        triangle_fragment.edtTriangleSideB.text.clear()
        triangle_fragment.edtTriangleSideC.text.clear()

        triangleFragment.ctrTriangleImage.setImageResource(R.drawable.null_triangle)

    }

    fun sendAlert(int: Int) {
        //  TODO: if int == 0 then present null alert message
        //  TODO: if int == 1 then present value must be >0 and <100 message

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

