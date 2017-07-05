package com.easy.kotlin

/**
 * Created by jack on 2017/7/4.
 */

class Aook(name: String)

class Cook(name: String) {
    val name = name
}

class Dook(val name: String)
class Eook(var name: String)

data class Book(val name: String)
data class Fook(var name: String)

//data class Gook // error, data class must have at least one primary constructor parameter
//data class Hook(name: String)// error, data class must have only var/val property
//abstract data class Iook(val name: String) // modifier abstract is incompatible with data
//open data class Jook(val name: String) // modifier abstract is incompatible with data
//sealed data class Kook(val name: String)// modifier sealed is incompatible with data
//inner data class Look(val name: String)// modifier inner is incompatible with data


final data class Mook(val name: String) // modifier abstract is incompatible with data

data class User(
        val name: String,
        val gender: String,
        val age: Int
) {
    fun validate(): Boolean {
        return true
    }
}


class P {
    inner class INBase
}

sealed class SBase

open class DBase
interface IBaseA
interface IBaseB

data class LoginUser(val name: String = "", val password: String = "") : DBase(), IBaseA, IBaseB {

    var isActive = true

    constructor(name: String, password: String, isActive: Boolean) : this(name, password) {
        this.isActive = isActive
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

//    override fun toString(): String {
//        return super.toString()
//    }

    fun validate(): Boolean {
        return true
    }
}


fun main(args: Array<String>) {
    val aook = Aook("Aook")

    val cook = Cook("Cook")
    cook.name


    val dook = Dook("Dook")
    dook.name
    val eook = Eook("Eook")
    eook.name

    val book = Book("Book")
    book.name
    book.copy("Book2")

    val jack = User("Jack", "Male", 1)
    jack.name
    jack.gender
    jack.age
    jack.toString()
    jack.validate()


    val olderJack = jack.copy(age = 2)
    val anotherJack = jack.copy(name = "Jacky", age = 10)

    val rose = User("Rose", "Female", 2)
    rose.name
    rose.gender
    rose.age
    rose.toString()

    val helen = User("Helen", "Female", 15)
    val (name, gender, age) = helen
    println("$name, $gender, $age years of age")

    val loginUser1 = LoginUser("Admin", "admin")
    println(loginUser1.component1())
    println(loginUser1.component2())
    println(loginUser1.name)
    println(loginUser1.password)
    println(loginUser1.toString())

    val loginUser2 = LoginUser(password = "root", name = "root")

    val loginUser3 = LoginUser()
    loginUser3.name
    loginUser3.password

}
