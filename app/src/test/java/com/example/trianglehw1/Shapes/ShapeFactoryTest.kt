package com.example.trianglehw1.Shapes

import com.example.trianglehw1.Shapes.Triangles.EquilateralTriangle
import com.example.trianglehw1.Shapes.Triangles.IsoscelesTriangle
import com.example.trianglehw1.Shapes.Triangles.ScaleneTriangle
import com.example.trianglehw1.Shapes.Triangles.InvalidTriangle
import junit.framework.Assert.*
import org.junit.Test

internal class ShapeFactoryTest{

    @Test
    fun `Equilateral Triangle`(){
        val sides = arrayOf(1.0, 1.0, 1.0)

        val sut = ShapeFactory(sides).create()

        assertTrue(sut is EquilateralTriangle)
    }

    @Test
    fun `Scalene triangle1`(){
        val sides = arrayOf(4.0, 2.0, 3.0)
        val sut = ShapeFactory(sides).create()
        assertTrue(sut is ScaleneTriangle)

    }

    @Test
    fun `Isosceles Triangle`(){
        val sides = arrayOf(4.0, 3.0, 3.0)

        val sut = ShapeFactory(sides).create()

        assertTrue(sut is IsoscelesTriangle)
    }

    @Test
    fun `Minimum Number of Inputs haven't been Added`(){
        val sut = ShapeFactory(arrayOf(1.0, 2.0)).create()

        assertTrue(sut is InvalidShape)
    }

    @Test
    fun `Maximum Number of Inputs was Exceeded`(){
        val sides = arrayOf(1.0, 2.0, 3.0, 4.0)
        val sut = ShapeFactory(sides).create()

        assertTrue(sut is InvalidShape)
    }

    @Test
    fun `Lower Limit Boundary Testing`() {
        val sides = arrayOf(0.0, -1.0, -2.0)
        val sut = ShapeFactory(sides).create()

        assertTrue(sut is InvalidShape)
    }

    @Test
    fun `Triangle Violating Inequality Theorem`() {
        val sides = arrayOf(32.0, 1.0, 2.0)
        val sut = ShapeFactory(sides).create()

        assertTrue(sut is InvalidTriangle)
    }
}