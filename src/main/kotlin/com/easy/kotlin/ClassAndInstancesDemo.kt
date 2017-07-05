package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */

fun main(args: Array<String>) {
    val world = World()
    println(world)
    println(world::class)

    val w1 = World1()
    println(w1.yin)
    println(w1.yang)

    val w2 = World2()
    println(w2.plus())

//    val p = Person("Jack", "28")


}

class World

class World1 {
    val yin: Int = 0
    val yang: Int = 1
}

class World2 {
    val yin: Int = 0
    val yang: Int = 1

    fun plus(): Int {
        return yin + yang
    }
}

abstract class Person(var name: String, var age: Int) : Any() {

    abstract var addr: String
    abstract val weight: Float

    abstract fun doEat()
    abstract fun doWalk()

    fun doSwim() {
        println("I am Swimming ... ")
    }

    open fun doSleep() {
        println("I am Sleeping ... ")
    }
}

class Teacher(name: String, age: Int) : Person(name, age) {
    override var addr: String = "HangZhou"
    override val weight: Float = 100.0f

    override fun doEat() {
        println("Teacher is Eating ... ")
    }

    override fun doWalk() {
        println("Teacher is Walking ... ")
    }

    override fun doSleep() {
        super.doSleep()
        println("Teacher is Sleeping ... ")
    }

//    override fun doSwim() {
//        println("Teacher is Swimming ... ")
//    }
}


class Programmer(override var addr: String, override val weight: Float, name: String, age: Int) : Person(name, age) {
    override fun doEat() {
        println("Programmer is Eating ... ")
    }

    override fun doWalk() {
        println("Programmer is Walking ... ")
    }

}

abstract class Writer(override var addr: String, override val weight: Float, name: String, age: Int) : Person(name, age) {
    override fun doEat() {
        println("Programmer is Eating ... ")
    }

    abstract override fun doWalk()

}

