package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class ScaleneTriangleTests {
    private val scaleneTriangle = ScaleneTriangle()

    @Test
    fun `Should Get Scalene Triangle Picture Id When Called`() {

        val pictureId = scaleneTriangle.getPictureId()

        assertEquals(pictureId, R.drawable.scalene_triangle)
    }

    @Test
    fun `Should Get Scalene Triangle Name When Called`() {

        val name = scaleneTriangle.getDescription()

        assertEquals(name, R.string.scalene_triangle_description.toString())
    }
}