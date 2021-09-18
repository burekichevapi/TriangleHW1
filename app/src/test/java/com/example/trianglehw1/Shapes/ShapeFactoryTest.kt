package com.example.trianglehw1.Shapes

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class ShapeFactoryTest{

    @Test
    fun `Equilateral Triangle`(){
        var results = ShapeFactory.create(
            sides = arrayOf(1.0, 1.0, 1.0)
        )

        var totalResults = results.getName()
        assertEquals("Equilateral Triangle", totalResults)
    }

    @Test
    fun `Scalene triangle1`(){
        var results = ShapeFactory.create(
            sides = arrayOf(1.0,2.0,3.0)
        )

        var totalResults = results.getName()
        assertEquals("Scalene Triangle", totalResults)
    }

    @Test
    fun `Isosceles Triangle`(){
        var results = ShapeFactory.create(
            sides = arrayOf(1.0, 1.0, 2.0)
        )

        var totalResult = results.getName()
        assertEquals("Isosceles Triangle", totalResult)
    }

    @Test
    fun `Minimum Number of Inputs haven't been Added`(){
        var results = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0)
        )

        var totalResult = results.getName()
        assertEquals("null", totalResult)
    }

    @Test
    fun `Maximum Number of Inputs was Exceeded`(){
        var results = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0, 3.0, 4.0)
        )

        var totalResult = results.getName()
        assertEquals("null", totalResult)
    }

    @Test
    fun `Lower Limit Boundary Testing`(){
        var results = ShapeFactory.create(
            sides = arrayOf(0.0, -1.0, -2.0)
        )

        var totalResult = results.getName()
        assertEquals("null", totalResult)
    }
}