package com.example.trianglehw1.Shapes

enum class ShapeType(val numberOfSides: Int) {
    TRIANGLE(3);
}

abstract class Shape {

    companion object Null: Shape() {
        override fun getPictureId(): Int = -1
        override fun getDescription(): String = "null"
    }

    abstract fun getPictureId(): Int
    abstract fun getDescription(): String
}