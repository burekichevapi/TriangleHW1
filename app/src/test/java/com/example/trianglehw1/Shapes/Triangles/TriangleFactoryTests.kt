package com.example.trianglehw1.Shapes.Triangles

import junit.framework.Assert
import org.junit.Test

class TriangleFactoryTests {
    @Test
    fun `Equilateral Triangle`(){
        val sides = arrayOf(1.0, 1.0, 1.0)
        val sut = TriangleFactory(sides).create()

        Assert.assertTrue(sut is EquilateralTriangle)
    }

    @Test
    fun `Scalene triangle1`(){
        val sides = arrayOf(4.0, 2.0, 3.0)
        val sut = TriangleFactory(sides).create()
        Assert.assertTrue(sut is ScaleneTriangle)

    }

    @Test
    fun `Isosceles Triangle`(){
        val sides = arrayOf(4.0, 3.0, 3.0)
        val sut = TriangleFactory(sides).create()

        Assert.assertTrue(sut is IsoscelesTriangle)
    }

    @Test
    fun `Minimum Number of Inputs haven't been Added`(){
        val sides = arrayOf(1.0, 2.0)
        val sut = TriangleFactory(sides).create()

        Assert.assertTrue(sut is InvalidTriangle)
    }

    @Test
    fun `Maximum Number of Inputs was Exceeded`(){
        val sides = arrayOf(1.0, 2.0, 3.0, 4.0)
        val sut = TriangleFactory(sides).create()

        Assert.assertTrue(sut is InvalidTriangle)
    }

    @Test
    fun `Lower Limit Boundary Testing`() {
        val sides = arrayOf(0.0, -1.0, -2.0)
        val sut = TriangleFactory(sides).create()

        Assert.assertTrue(sut is InvalidTriangle)
    }

    @Test
    fun `Triangle Violating Inequality Theorem`() {
        val sides = arrayOf(32.0, 1.0, 2.0)
        val sut = TriangleFactory(sides).create()

        Assert.assertTrue(sut is InvalidTriangle)
    }
}