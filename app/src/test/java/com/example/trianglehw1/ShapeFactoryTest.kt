package com.example.trianglehw1.Shapes

import com.example.trianglehw1.Shapes.Triangles.EquilateralTriangle
import com.example.trianglehw1.Shapes.Triangles.IsoscelesTriangle
import com.example.trianglehw1.Shapes.Triangles.ScaleneTriangle
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class ShapeFactoryTest{

    @Test
    fun `Equilateral Triangle`(){
        var equilateralTriangle = ShapeFactory.create(
            sides = arrayOf(1.0, 1.0, 1.0)
        )

        assertEquals(equilateralTriangle::class, EquilateralTriangle()::class)
    }

    @Test
    fun `Scalene triangle1`(){
        var scaleneTriangle = ShapeFactory.create(
            sides = arrayOf(1.0,2.0,3.0)
        )

        assertEquals(scaleneTriangle::class, ScaleneTriangle()::class)
    }

    @Test
    fun `Isosceles Triangle`(){
        var isoscelesTriangle = ShapeFactory.create(
            sides = arrayOf(1.0, 1.0, 2.0)
        )

        assertEquals(isoscelesTriangle::class, IsoscelesTriangle()::class)
    }

    @Test
    fun `Minimum Number of Inputs haven't been Added`(){
        var minimumInputs = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0)
        )

        assertEquals(minimumInputs::class, Shape.Null::class)
    }

    @Test
    fun `Maximum Number of Inputs was Exceeded`(){
        var maximumInputs = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0, 3.0, 4.0)
        )

        assertEquals(maximumInputs::class, Shape.Null::class)
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