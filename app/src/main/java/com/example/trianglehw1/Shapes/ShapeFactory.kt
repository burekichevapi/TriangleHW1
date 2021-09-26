package com.example.trianglehw1.Shapes

import com.example.trianglehw1.Shapes.Triangles.TriangleFactory

class ShapeFactory(sides: Array<Double>) {
    private lateinit var _factory: IShapeFactory
    private val _sides = sides

    fun create(): Shape {
        if(isInvalidShape())
            return InvalidShape()

        if(ShapeType.IS.TRIANGLE(_sides))
            _factory = TriangleFactory(_sides)
        else
            return InvalidShape()

        return  _factory.create()
    }

    private fun isInvalidShape(): Boolean {
        if(ShapeType.IS.INVALID_WITH_NEGATIVE_SIDES(_sides))
            return true

        if(ShapeType.IS.INVALID_WITH_LESS_THAN_3_SIDES(_sides))
            return true

        return false
    }

}