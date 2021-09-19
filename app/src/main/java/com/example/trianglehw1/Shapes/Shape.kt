package com.example.trianglehw1.Shapes

import com.example.trianglehw1.R

abstract class Shape {

    companion object Null: Shape() {
        override fun getPictureId(): Int = R.drawable.null_shape
        override fun getDescriptionId(): Int = R.string.clear_text
    }

    abstract fun getPictureId(): Int
    abstract fun getDescriptionId(): Int
}