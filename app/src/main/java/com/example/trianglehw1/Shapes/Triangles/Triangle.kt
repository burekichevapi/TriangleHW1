package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.Shapes.Shape
import com.example.trianglehw1.Result
abstract class Triangle(): Shape() {
    companion object Factory {
        fun create(sides: Array<Double>): Result<Triangle, Shape> {
            val differentSides = sides.toSet().count()
            if (!isvalidTriangle(sides))
                return Result.Error(Shape.Null)
            if(differentSides == 1)
                return Result.Ok(EquilateralTriangle())

            if(differentSides == 2)
                return Result.Ok(IsoscelesTriangle())

            return Result.Ok(ScaleneTriangle())
        }

        private fun isvalidTriangle(differentSides: Array<Double>): Boolean {
            //Todo: add validations
            return true
        }
    }
}