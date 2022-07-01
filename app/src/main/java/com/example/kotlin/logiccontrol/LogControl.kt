package com.example.kotlin.logiccontrol

class LogControl {

    fun largeNum(num1: Int, num2: Int): Int {
        var value = 0
        if (num1 > num2) {
            value = num1
        } else {
            value = num2
        }
        return value
    }

    fun largeNum2(num1: Int, num2: Int): Int {
        val value = if (num1 > num2) {
            num1
        } else {
            num2
        }
        return value
    }

    fun largeNum3(num1: Int, num2: Int): Int = if (num1 > num2) {
        num1
    } else {
        num2
    }

    fun getScore(name: String): Int = if (name == "a") {
        100
    } else if (name == "b") {
        99
    } else if (name == "c") {
        98
    } else {
        59
    }

    fun getScore2(name: String): Int = when (name) {
        "a" -> 100
        "b" -> 99
        "c" -> 98
        else -> 59
    }

    fun getScore3(name: String): Int = when {
        name.startsWith("a") -> 100
        name == "b" -> 99
        name == "c" -> 98
        else -> 59
    }

    fun getType(num: Number): String = when (num) {
        is Int -> "Int"
        is Long -> "Long"
        else -> "other"
    }

    fun getLow(num: Int): Int = when {
        num < 10 -> 0
        num < 20 -> 10
        num < 30 -> 20
        else -> 30
    }

    fun print1To10() {
        for (i in 0..10) {
            println(i)
        }
    }

    fun print1To10Tow() {
        for (i in 0 until 11 step 3) {
            print(i)
        }
    }


}

fun main() {
    val control = LogControl()
    control.print1To10Tow()
}