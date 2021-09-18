package com.example.trianglehw1.Shapes

import com.example.trianglehw1.Result
import com.example.trianglehw1.Shapes.Triangles.NullTriangle
import com.example.trianglehw1.Shapes.Triangles.Triangle

object ShapeFactory {
    fun create(sides: Array<Double>): Result<Triangle, Triangle> {

        if(sides.count() == ShapeType.TRIANGLE.numberOfSides)
            return Triangle.Factory.create(sides)

        return Result.Error(NullTriangle())
    }
}