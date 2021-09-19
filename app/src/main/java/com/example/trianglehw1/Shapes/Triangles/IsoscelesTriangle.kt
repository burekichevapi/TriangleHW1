package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R

class IsoscelesTriangle(): Triangle() {

    override fun getPictureId(): Int {
        return R.drawable.isosceles_triangle
    }

    override fun getDescriptionId(): Int {
        return R.string.isosceles_triangle_description
    }
}