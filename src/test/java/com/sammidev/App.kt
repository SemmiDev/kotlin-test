package com.sammidev

import org.junit.jupiter.api.Test
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

    
}