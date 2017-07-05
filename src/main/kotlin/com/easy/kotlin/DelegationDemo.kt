package com.easy.kotlin

import java.util.*

/**
 * Created by jack on 2017/7/5.
 */

interface Subject {
    fun hello()
}

class RealSubject(val name: String) : Subject {
    override fun hello() {
        val now = Date()
        println("Hello, REAL $name! Now is $now")
    }
}

class ProxySubject(val sb: Subject) : Subject by sb {
    override fun hello() {
        println("Before ! Now is ${Date()}")
        sb.hello()
        println("After ! Now is ${Date()}")
    }
}

fun main(args: Array<String>) {
    val subject = RealSubject("World")
    subject.hello()
    println("-------------------------")
    val proxySubject = ProxySubject(subject)
    proxySubject.hello()
}
