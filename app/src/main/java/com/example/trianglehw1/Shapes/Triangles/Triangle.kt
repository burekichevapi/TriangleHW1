package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.Shapes.Shape

abstract class Triangle(): Shape() {
    companion object Factory {
        fun create(sides: Array<Double>): Triangle {
            val differentSides = sides.toSet().count()

            if(differentSides == 1)
                return EquilateralTriangle()

            if(differentSides == 2)
                return IsoscelesTriangle()

            return ScaleneTriangle()
        }
    }
}