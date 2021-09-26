package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.Shapes.IShapeFactory

class TriangleFactory(sides: Array<Double>): IShapeFactory {
    private val _sides = sides

    override fun create(): Triangle {
        if(!isValidTriangle())
            return InvalidTriangle()

        val differentSides = _sides.toSet().count()

        if (differentSides == 1)
            return EquilateralTriangle()

        if (differentSides == 2)
            return IsoscelesTriangle()

        return ScaleneTriangle()
    }

    private fun isValidTriangle(): Boolean {
        if(_sides.count() < 3)
            return false

        if (!passesInequalityTheorem())
            return false

        return true
    }

    private fun passesInequalityTheorem(): Boolean {
        val a = _sides[0]
        val b = _sides[1]
        val c = _sides[2]

        if(a + b <= c)
            return false

        if(a + c <= b)
            return false

        if(c + b <= a)
            return false

        return true
    }
}