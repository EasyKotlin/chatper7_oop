package com.easy.kotlin

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by jack on 2017/7/5.
 */

class NormalPropertiesDemo {
    var content: String = "NormalProperties init content"
}


class DelegatePropertiesDemo {
    var content: String by Content()

    override fun toString(): String {
        return "DelegatePropertiesDemo Class"
    }
}

class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>): String {
        return "${delegatePropertiesDemo} property '${property.name}' = 'Balalala ... ' "
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>, value: String) {
        println("${delegatePropertiesDemo} property '${property.name}' is setting value: '$value'")
    }
}


class PostHierarchy {
    var level: String by Delegates.observable("P0",
            { property: KProperty<*>,
              oldValue: String,
              newValue: String ->
                println("$oldValue -> $newValue")
            })

    val onChange2 = { property: KProperty<*>,
                      oldValue: String,
                      newValue: String ->
        println("$oldValue -> $newValue")
    }
    var level2: String by Delegates.observable("P0", onChange2)

    /**
     * If the callback returns `true` the value of the property is being set to the new value,
     *  and if the callback returns `false` the new value is discarded and the property remains its old value.
     */
    var grade: String by Delegates.vetoable("T0", {
        property, oldValue, newValue ->
        true
    })

    var notChangeGrade: String by Delegates.vetoable("T0", {
        property, oldValue, newValue ->
        false
    })

    var name: String by Delegates.notNull()
}


class Account(val map: Map<String, Any?>) {
    val name: String by map
    val password: String by map
}


class MutableAccount(val map: MutableMap<String, Any?>) {
    var name: String by map
    var password: String by map
}

fun getNormalValue(): String {
    println("normal we go 3!")
    println("normal we go 2!")
    println("normal we go 1!")
    return "Hello, normal ! "
}

fun main(args: Array<String>) {
    val n = NormalPropertiesDemo()
    println(n.content)
    n.content = "Lao tze"
    println(n.content)

    val e = DelegatePropertiesDemo()
    println(e.content) // call Content.getValue
    e.content = "Confucius" // call Content.setValue
    println(e.content) // call Content.getValue

    val normalValue = getNormalValue()
    println(normalValue)
    println(normalValue)

    val lambdaValue: String = {
        println("lambda we go 3!")
        println("lambda we go 2!")
        println("lambda we go 1!")
        "Hello, lambda ! "
    }.invoke()

    println(lambdaValue)
    println(lambdaValue)


    val synchronizedLazyImpl = lazy({
        println("lazyValueSynchronized1  3!")
        println("lazyValueSynchronized1  2!")
        println("lazyValueSynchronized1  1!")
        "Hello, lazyValueSynchronized1 ! "
    })

    val synchronizedLazyImpl2 = lazy(LazyThreadSafetyMode.SYNCHRONIZED, {
        println("lazyValueSynchronized1  3!")
        println("lazyValueSynchronized1  2!")
        println("lazyValueSynchronized1  1!")
        "Hello, lazyValueSynchronized1 ! "
    })

    val lazyValueSynchronized1: String by synchronizedLazyImpl
    println(lazyValueSynchronized1)
    println(lazyValueSynchronized1)


    val lazyValueSynchronized2: String by lazy {
        println("lazyValueSynchronized2  3!")
        println("lazyValueSynchronized2  2!")
        println("lazyValueSynchronized2  1!")
        "Hello, lazyValueSynchronized2 ! "
    }

    println(lazyValueSynchronized2)
    println(lazyValueSynchronized2)


    val lazyValuePublication: String by lazy(LazyThreadSafetyMode.PUBLICATION, {
        println("lazyValuePublication 3!")
        println("lazyValuePublication 2!")
        println("lazyValuePublication 1!")
        "Hello, lazyValuePublication ! "
    })

    println(lazyValuePublication)
    println(lazyValuePublication)

    val lazyValueNone: String by lazy(LazyThreadSafetyMode.NONE, {
        println("lazyValueNone 3!")
        println("lazyValueNone 2!")
        println("lazyValueNone 1!")
        "Hello, lazyValueNone ! "
    })

    println(lazyValueNone)
    println(lazyValueNone)

    val ph = PostHierarchy()
    ph.level = "P1"
    ph.level = "P1"
    ph.level = "P2"
    ph.level = "P3"
    println(ph.level) // P3

    ph.level2 = "M1"
    ph.level2 = "M2"
    println(ph.level2) // M2


    ph.grade = "T1"
    ph.grade = "T2"
    ph.grade = "T3"
    println(ph.grade) // T3

    ph.notChangeGrade = "T1"
    ph.notChangeGrade = "T2"
    ph.notChangeGrade = "T3"
    println(ph.notChangeGrade) // T0

//    ph.name = null
    ph.name = "Jack"
    println(ph.name)


    val account = Account(mapOf(
            "name" to "admin",
            "password" to "admin"
    ))

    println("Account(name=${account.name}, password = ${account.password})")

    val maccount = MutableAccount(mutableMapOf(
            "name" to "admin",
            "password" to "admin"
    ))

    maccount.password = "root"

    println("MutableAccount(name=${maccount.name}, password = ${maccount.password})")
}
