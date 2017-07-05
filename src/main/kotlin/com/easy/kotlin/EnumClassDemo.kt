package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */


enum class Direction {
    NORTH, SOUTH, WEST, EAST
}


enum class RGB { RED, GREEN, BLUE }


enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


fun main(args: Array<String>) {
    val north = Direction.NORTH
    val red = Color.RED
    println(red.rgb)

    val rgbs = enumValues<RGB>().joinToString { "${it.name} : ${it.ordinal} " }
    println(rgbs)

    val colors = enumValues<Color>().joinToString { "${it.rgb} : ${it.name} : ${it.ordinal} " }
    println(colors)


    val s = ActivtyLifeState.onCreate
    println(s.signal())
}

enum class ActivtyLifeState {
    onCreate {
        override fun signal() = onStart
    },

    onStart {
        override fun signal() = onStop
    },

    onStop {
        override fun signal() = onStart
    },

    onDestroy {
        override fun signal() = onDestroy
    };

    abstract fun signal(): ActivtyLifeState
}
