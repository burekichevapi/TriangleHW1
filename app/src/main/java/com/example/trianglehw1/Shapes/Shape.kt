package com.example.trianglehw1.Shapes

import com.example.trianglehw1.R

abstract class Shape {

    companion object Invalid: Shape() {
        override fun getPictureId(): Int {
            return R.drawable.invalid_shape
        }

        override fun getDescriptionId(): Int {
            return R.string.invalid_shape_description
        }
    }

    abstract fun getPictureId(): Int
    abstract fun getDescriptionId(): Int
}