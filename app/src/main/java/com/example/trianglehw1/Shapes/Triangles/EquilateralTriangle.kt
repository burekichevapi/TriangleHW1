package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R

class EquilateralTriangle(): Triangle() {

    override fun getPictureId(): Int {
        return R.drawable.equilateral_triangle;
    }

    override fun getDescriptionId(): Int {
        return R.string.equilateral_triangle_description
    }
}