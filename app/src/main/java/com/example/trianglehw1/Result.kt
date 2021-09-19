package com.example.trianglehw1

sealed class Result<out T, out E>{
    class Ok<out T>(val value: T): Result<T, Nothing>(){}
    class Error<out E>(val error: E): Result<Nothing, E>(){}
}


