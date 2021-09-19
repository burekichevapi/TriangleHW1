package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.Shapes.Shape

abstract class Triangle(): Shape() {
    companion object Factory {
        fun create(sides: Array<Double>): Triangle {

            if(!passesInequalityTheorem(sides))
                return InvalidTriangle()

            val differentSides = sides.toSet().count()

            if(differentSides == 1)
                return EquilateralTriangle()

            if(differentSides == 2)
                return IsoscelesTriangle()

            return ScaleneTriangle()
        }

        private fun passesInequalityTheorem(sides: Array<Double>): Boolean {
            val a = sides[0]
            val b = sides[1]
            val c = sides[2]

            if(a + b <= c)
                return false

            if(a + c <= b)
                return false

            if(c + b <= a)
                return false

            return true
        }
    }
}