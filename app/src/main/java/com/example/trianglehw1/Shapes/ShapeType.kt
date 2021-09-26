package com.example.trianglehw1.Shapes

enum class ShapeType() {
    IS;

    fun TRIANGLE(sides: Array<Double>): Boolean {
        return sides.count() == 3
    }

    fun INVALID_WITH_LESS_THAN_3_SIDES(sides: Array<Double>): Boolean {
        return sides.count() < 3
    }

    fun INVALID_WITH_NEGATIVE_SIDES(sides: Array<Double>): Boolean {
        sides.forEach {
            if(it <= 0.0)
                return true
        }

        return false
    }
}