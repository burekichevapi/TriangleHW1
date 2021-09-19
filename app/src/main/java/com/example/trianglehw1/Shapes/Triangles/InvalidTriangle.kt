package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R

class InvalidTriangle: Triangle() {

    override fun getPictureId(): Int {
        return R.drawable.invalid_triangle
    }

    override fun getDescriptionId(): Int {
        return R.string.invalid_triangle_description
    }
}