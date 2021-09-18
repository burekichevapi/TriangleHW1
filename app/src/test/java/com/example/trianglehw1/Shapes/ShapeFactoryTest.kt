package com.example.trianglehw1.Shapes

import com.example.trianglehw1.Shapes.Triangles.EquilateralTriangle
import com.example.trianglehw1.Shapes.Triangles.IsoscelesTriangle
import com.example.trianglehw1.Shapes.Triangles.ScaleneTriangle
import com.example.trianglehw1.Result
import com.example.trianglehw1.Shapes.Triangles.NullTriangle
import junit.framework.Assert.*
import org.junit.Assert
import org.junit.Test
import java.lang.Error

internal class ShapeFactoryTest{

    @Test
    fun `Equilateral Triangle`(){
        //Arrange
        var expectedResult = EquilateralTriangle()::class
        //Act
        var sut = ShapeFactory.create(
            sides = arrayOf(1.0, 1.0, 1.0)
        )

        //Assert
        if (sut is Result.Ok)
            assertTrue(sut.value is EquilateralTriangle)
        else
            fail()
    }

    @Test
    fun `Scalene triangle1`(){
        //Arrange
        var expected = ScaleneTriangle::class.java

        //Act
        var sut = ShapeFactory.create(
            sides = arrayOf(1.0,2.0,3.0)
        )
        if (sut is Result.Ok)
            assertTrue(sut.value is ScaleneTriangle)
        else
            fail()

    }

    @Test
    fun `Isosceles Triangle`(){
        //Act
        var sut = ShapeFactory.create(
            sides = arrayOf(1.0, 1.0, 2.0)
        )

        //Assert
        if (sut is Result.Ok)
            assertTrue(sut.value is IsoscelesTriangle)
        else
            fail()
    }

    @Test
    fun `Minimum Number of Inputs haven't been Added`(){
        //Act
        var sut = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0)
        )

        //Assert
        if(sut is Result.Error)
            assertTrue(sut.error is NullTriangle)
        else
            fail()
    }

    @Test
    fun `Maximum Number of Inputs was Exceeded`(){
        var sut = ShapeFactory.create(
            sides = arrayOf(1.0, 2.0, 3.0, 4.0)
        )

        //Assert
        assertTrue(sut is Result.Error)
        if (sut is Result.Error)
            assertTrue(sut.error is NullTriangle)
        else
            fail()
    }

    @Test
    fun `Lower Limit Boundary Testing`() {
        var sut = ShapeFactory.create(
            sides = arrayOf(0.0, -1.0, -2.0)
        )

        if(sut is Result.Error)
            assertTrue(sut.error is NullTriangle)
        else
            fail()
    }
}