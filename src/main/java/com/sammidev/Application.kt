package com.sammidev

class Application {
    fun hello(name: String) = "hello $name"
}

class Calculator {
    fun add(a: Int, b: Int) = a + b
    fun multiply(a: Int, b: Int) = a * b
    fun divide(a: Int, b: Int) = a / b
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