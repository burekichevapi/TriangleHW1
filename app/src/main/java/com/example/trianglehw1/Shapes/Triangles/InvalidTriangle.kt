package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R

class InvalidTriangle: Triangle() {

    override fun getPictureId(): Int {
        return R.drawable.invalid_triangle
    }

    override fun getDescription(): String {
        return R.string.invalid_triangle_description.toString()
    }
}