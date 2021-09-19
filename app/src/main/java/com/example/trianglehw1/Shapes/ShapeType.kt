package com.example.trianglehw1.Shapes

enum class ShapeType() {
    IS;

    fun TRIANGLE(numberOfSides: Int): Boolean {
        return numberOfSides == 3
    }

    fun invalidWithNegativeSides(sides: Array<Double>): Boolean {
        sides.forEach {
            if(it <= 0.0)
                return true
        }
        return false
    }
}