package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R
import junit.framework.Assert.assertEquals
import org.junit.Test


internal class EquilateralTriangleTests {

    private val equilateralTriangle = EquilateralTriangle()

    @Test
    fun `Should Get Equilateral Triangle Picture Id When Called`() {

        val pictureId = equilateralTriangle.getPictureId()

        assertEquals(pictureId, R.drawable.equilateral_triangle)
    }

    @Test
    fun `Should Get Equilateral Triangle Name When Called`() {

        val description = equilateralTriangle.getDescriptionId()

        assertEquals(description, R.string.equilateral_triangle_description)
    }

}