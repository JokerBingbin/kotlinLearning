package com.example.kotlin.oo.constructor

class Car(val brand: String, color: String) {

    init {
        println("车的品牌是$brand")
        println("车的颜色是$color")
    }

    fun printBrand() {
        println("车的品牌是$brand")
    }

}