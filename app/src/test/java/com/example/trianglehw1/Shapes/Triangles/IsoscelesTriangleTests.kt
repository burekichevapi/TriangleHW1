package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class IsoscelesTriangleTests {
    private val isoscelesTriangle = IsoscelesTriangle()

    @Test
    fun `Should Get Isosceles Triangle Picture Id When Called`() {

        val pictureId = isoscelesTriangle.getPictureId()

        assertEquals(pictureId, R.drawable.isosceles_triangle)
    }

    @Test
    fun `Should Get Isosceles Triangle Name When Called`() {

        val name = isoscelesTriangle.getDescription()

        assertEquals(name, R.string.isosceles_triangle_description.toString())
    }
}