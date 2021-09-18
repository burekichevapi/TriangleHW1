package com.example.trianglehw1.Shapes

enum class ShapeType(val numberOfSides: Int) {
    TRIANGLE(3);
}

abstract class Shape {

    companion object Null: Shape() {
        override fun getPicture(): String = "null"
        override fun getName(): String = "null"
    }

    abstract fun getPicture(): String
    abstract fun getName(): String
}