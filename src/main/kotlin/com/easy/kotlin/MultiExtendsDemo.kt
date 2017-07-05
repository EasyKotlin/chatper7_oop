package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */

abstract class Animal {
    fun doEat() {
        println("Animal Eating")
    }
}


abstract class Plant {
    fun doEat() {
        println("Plant Eating")
    }
}


interface IRunnable {
    fun doRun()
}

interface IFlyable {
    fun doFly()
}

class Dog : Animal(), IRunnable {
    override fun doRun() {
        println("Dog Running")
    }
}

class Eagle : Animal(), IFlyable {
    override fun doFly() {
        println("Eagle Flying")
    }
}

// 始祖鸟, 能飞也能跑
class Archaeopteryx : Animal(), IRunnable, IFlyable {
    override fun doRun() {
        println("Archaeopteryx Running")
    }

    override fun doFly() {
        println("Archaeopteryx Flying")
    }

}

fun main(args: Array<String>) {
    val d = Dog()
    d.doEat()
    d.doRun()

    val e = Eagle()
    e.doEat()
    e.doFly()

    val a = Archaeopteryx()
    a.doEat()
    a.doFly()
    a.doRun()
}


//父类
open class Base(type: String) {
    open fun doSomething() {}
}

//子类
class SubClass(type: String) : Base(type) {
    override fun doSomething() {
        super.doSomething()
    }
}

