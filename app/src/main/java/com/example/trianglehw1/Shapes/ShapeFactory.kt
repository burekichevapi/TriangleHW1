package com.example.trianglehw1.Shapes

import com.example.trianglehw1.Shapes.Triangles.Triangle

object ShapeFactory {
    fun create(sides: Array<Double>): Shape {

        if(sides.count() == ShapeType.TRIANGLE.numberOfSides)
            return Triangle.Factory.create(sides)

        return Shape.Null
    }
}