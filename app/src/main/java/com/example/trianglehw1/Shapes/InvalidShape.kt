package com.example.trianglehw1.Shapes

import com.example.trianglehw1.R

open class InvalidShape: Shape() {
    override fun getPictureId(): Int {
        return R.drawable.invalid_shape
    }

    override fun getDescription(): String {
        return R.string.invalid_shape_description.toString()
    }

}