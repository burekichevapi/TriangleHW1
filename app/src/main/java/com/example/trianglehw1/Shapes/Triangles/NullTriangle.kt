package com.example.trianglehw1.Shapes.Triangles

import com.example.trianglehw1.R

class NullTriangle : Triangle(){
    override fun getPictureId(): Int {
        //Todo: Add reference to error image
        return R.drawable.equilateral_triangle
    }

    override fun getDescription(): String {
        return R.string.Null_triangle_description.toString()
    }
}