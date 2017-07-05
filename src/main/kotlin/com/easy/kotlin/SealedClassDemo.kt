package com.easy.kotlin

/**
 * Created by jack on 2017/7/4.
 */


sealed class Expression

class Unit : Expression()
data class Const(val number: Double) : Expression()
data class Sum(val e1: Expression, val e2: Expression) : Expression()
data class Multiply(val e1: Expression, val e2: Expression) : Expression()
object NaN : Expression()

fun eval(expr: Expression): Double = when (expr) {
    is Unit -> 1.0
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    is Multiply -> eval(expr.e1) * eval(expr.e2)
    NaN -> Double.NaN
// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}


fun main(args: Array<String>) {
    val u = eval(Unit())
    val a = eval(Const(1.1))
    val b = eval(Sum(Const(1.0), Const(9.0)))
    val c = eval(Multiply(Const(10.0), Const(10.0)))
    println(u)
    println(a)
    println(b)
    println(c)
}
