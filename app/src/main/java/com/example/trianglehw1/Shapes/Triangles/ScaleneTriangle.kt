package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R

class ScaleneTriangle(): Triangle() {

    override fun getPictureId(): Int {
        return R.drawable.scalene_triangle
    }

    override fun getDescriptionId(): Int {
        return R.string.scalene_triangle_description
    }
}