package com.easy.kotlin

/**
 * Created by jack on 2017/7/4.
 */

class NestedClassesDemo {
    class Outer {
        private val zero: Int = 0
        val one: Int = 1


        class Nested {
            fun getTwo() = 2

            fun accessOuter() = {
                //                println(zero) // cannot access outer class
//                println(one)  // cannot access outer class
            }

            class Nested1 {
                val three = 3
                fun getFour() = 4
            }
        }

        inner class Inner {
            fun accessOuter() = {
                println(zero)
                println(one)
            }

        }

        class AnonymousInnerClassDemo {
            var isRunning = false
            fun doRun() {
                Thread(object : Runnable {
                    override fun run() {
                        isRunning = true
                        println("doRun : i am running, isRunning = $isRunning")
                    }
                }).start()
            }

            fun doStop() {
                var isRunning = true
                Thread({
                    isRunning = false
                    println("doStop: i am not running, isRunning = $isRunning")
                }).start()
            }

            fun doWait() {
                var isRunning = true

                val wait = Runnable {
                    isRunning = false
                    println("doWait: i am waiting, isRunning = $isRunning")
                }

                Thread(wait).start()
            }

            fun doNotify() {
                var isRunning = true

                val wait = {
                    isRunning = false
                    println("doNotify: i notify, isRunning = $isRunning")
                }

                Thread(wait).start()
            }


        }


    }
}


fun main(args: Array<String>) {
    val one = NestedClassesDemo.Outer().one
    val two = NestedClassesDemo.Outer.Nested().getTwo()
    val three = NestedClassesDemo.Outer.Nested.Nested1().three
    val four = NestedClassesDemo.Outer.Nested.Nested1().getFour()
    println(one)
    println(two)
    println(three)
    println(four)

//    1
//    2
//    3
//    4

    val innerClass = NestedClassesDemo.Outer().Inner().accessOuter()

    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doRun()
    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doStop()
    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doWait()
    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doNotify()

}

