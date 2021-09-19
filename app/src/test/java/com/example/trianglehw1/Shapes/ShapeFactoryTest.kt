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

        val sut = ShapeFactory.create(
            sides = arrayOf(1.0, 1.0, 1.0)
        )

        assertTrue(sut is EquilateralTriangle)
    }

    @Test
    fun `Scalene triangle1`(){
        val sut = ShapeFactory.create(
            sides = arrayOf(4.0, 2.0, 3.0)
        )
        assertTrue(sut is ScaleneTriangle)

    }

    @Test
    fun `Isosceles Triangle`(){
        //Act
        val sut = ShapeFactory.create(
            sides = arrayOf(4.0, 3.0, 3.0)
        )

        assertTrue(sut is IsoscelesTriangle)
    }

    @Test
    fun `Minimum Number of Inputs haven't been Added`(){
        val sut = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0)
        )

        assertTrue(sut is Shape.Null)
    }

    @Test
    fun `Maximum Number of Inputs was Exceeded`(){
        val sut = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0, 3.0, 4.0)
        )

        assertTrue(sut is Shape.Null)
    }

    @Test
    fun `Lower Limit Boundary Testing`() {
        val sut = ShapeFactory.create(
            sides = arrayOf(0.0, -1.0, -2.0)
        )

        assertTrue(sut is InvalidShape)
    }

    @Test
    fun `Triangle Violating Inequality Theorem`() {
        val sut = ShapeFactory.create(
            sides = arrayOf(32.0, 1.0, 2.0)
        )

        assertTrue(sut is InvalidTriangle)
    }
}