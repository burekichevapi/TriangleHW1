package com.example.trianglehw1.Shapes

import com.example.trianglehw1.Shapes.Triangles.Triangle

object ShapeFactory {
    fun create(sides: Array<Double>): Shape {

        if(ShapeType.IS.INVALID_WITH_NEGATIVE_SIDES(sides))
            return InvalidShape()

        if(ShapeType.IS.TRIANGLE(sides.count()))
            return Triangle.Factory.create(sides)

        return Shape.Null
    }

}