package com.sammidev

import java.lang.IllegalArgumentException
import kotlin.math.sqrt

class Application {
    fun hello(name: String) = "hello $name"
    fun biggestDivisor(x: Int) = biggestDivisor(x, 2)
    fun biggestDivisor(x: Int, y: Int): Int {
        return when {
            x == y -> 1
            x % y == 0 -> x/y
            else -> biggestDivisor(x, y + 1)
        }
    }
    fun isSquare(x: Int): Boolean =  sqrt(x.toDouble()) % 1.0 == 0.0
}

class Others {
    fun factorial(n: Int): Int {
        if (n == 0 || n == 1) return 1
        return n * factorial(n-1)
    }
}

class Calculator {
    fun add(a: Int, b: Int) = a + b
    fun multiply(a: Int, b: Int) = a * b
    fun divide(a: Int, b: Int): Int {
        when (b) {
            0 -> throw IllegalArgumentException("can't divide by zero")
            else -> return a / b
        }
    }
    fun modulo(a: Int,b: Int): Int = a % b
}

data class KRS(
    var matkul: String,
    var sks: Int
)

data class Mahasiswa(
    var nama: String,
    var nim: String,
    var kelas: String,
    var semester: Int,
    var levelUKT: Int,
    var krs: List<KRS>
)