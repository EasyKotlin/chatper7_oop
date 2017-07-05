package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */


open class Student constructor(var name: String, var age: Int) : Any() {

    init {
        println("Student{name=$name, age=$age} created!")
    }

    var addr: String = ""
    open val weight: Float = 0.0f

    fun doEat() {
        println("Student Eating ... ")
    }

    fun doWalk() {
        println("Student Walking ... ")
    }

    open fun doSwim() {
        println("Student Swimming ... ")
    }

    open fun doSleep() {
        println("Student Sleeping ... ")
    }
}

annotation class MyAutowired

class ElementarySchoolStudent public @MyAutowired constructor(name: String, age: Int) : Student(name, age) {
    override var weight: Float = 80.0f

    constructor(name: String, age: Int, weight: Float) : this(name, age) {
        this.weight = weight
    }

    override fun doSleep() {
        super.doSleep()
        println("ElementaryStudent is Sleeping ... ")
    }

    override fun doSwim() {
        super.doSwim()
        println("ElementaryStudent is Swimming ... ")
    }
}


class MiddleSchoolStudent {
    constructor(name: String, age: Int) {
    }
}

class DontCreateMe private constructor() {
    var name: String = ""

    constructor(name: String) : this() {
        this.name = name
    }
}

fun main(args: Array<String>) {
    val student = Student("Jack", 10)
    student.doEat()
    student.doWalk()
    student.doSwim()
    student.doSleep()

    val elementaryStudent = ElementarySchoolStudent("Alice", 12)
    elementaryStudent.doEat()
    elementaryStudent.doWalk()
    elementaryStudent.doSwim()
    elementaryStudent.doSleep()

    // val dontCreateMe = DontCreateMe() // cannot access it
    val dontCreateMe = DontCreateMe("Me")

    val middleSchoolStudent = MiddleSchoolStudent("Jack", 12)
}
