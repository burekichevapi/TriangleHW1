package com.example.trianglehw1.Shapes

import com.example.trianglehw1.R

abstract class Shape {

    companion object Null: Shape() {
        override fun getPictureId(): Int = R.drawable.null_shape
        override fun getDescription(): String = ""
    }

    abstract fun getPictureId(): Int
    abstract fun getDescription(): String
}