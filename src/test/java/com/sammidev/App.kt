package com.sammidev

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class App {

    @Test
    fun testAppHasGreeting()  =  assertNotNull(Application().hello("sammidev"), "hello sammidev")

    @Test
    fun testAddSucces() = assertEquals(3, Calculator().add(1,2))

    @Test
    fun testNewStudent() {
        val sammi = Mahasiswa(
                "sammidev",
                "2003113923",
                "A",
                1,
                5,
                listOf(
                      KRS("mtk diskrit",5),
                      KRS("konsep pemrograman",5),
                      KRS("database",5),
                      KRS("gis",5)
                )
        )

        val testCountMatkul = sammi.krs.size
        assertEquals(4, testCountMatkul)
        assertEquals("sammidev", sammi.nama)
    }

    @Test
    fun testDivideSuccess() {
        val divider = Calculator().divide(10,2)
        assertEquals(5, divider)
    }

    @Test
    fun testDivideSuccessBecauseThrow() {
        val divide = Calculator().divide(2,0)
        assertThrows<IllegalArgumentException> {
            Calculator().divide(2,0)
        }
    }

    @Test
    fun testDivideError() {
        assertThrows<IllegalArgumentException> {
            Calculator().divide(10,2)
        }
    }

    @Test
    fun tesBiggestDivisorSuccess() {
        assertEquals(5, Application().biggestDivisor(10))
    }

    @Test
    fun testIsSquareSuccess() {
        assertEquals(true, Application().isSquare(16))
    }

    @Test
    fun testIsSquareError() {
        assertEquals(false, Application().isSquare(16))
    }

}