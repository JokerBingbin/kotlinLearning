package com.example.kotlin.oo.constructor

class Person(val name: String, val age: Int) {

    init {
        println("name is $name  age is $age")
    }

}

fun main() {
    val person = Person("Luka", 23)
}