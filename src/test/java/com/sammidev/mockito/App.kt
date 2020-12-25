package com.sammidev.mockito

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.test.assertEquals

class App {

    @Test
    fun testMocking() {

        // create mock
        val listMock = Mockito.mock(List::class.java) as List<String>

        // menambah behaviour di mock object
        Mockito.`when`(listMock[0]).thenReturn("sammidev")
        Mockito.`when`(listMock[1]).thenReturn("dev")
        Mockito.`when`(listMock[2]).thenReturn("sam")

        // test mock
        assertEquals("sammidev", listMock[0])
        assertEquals("sammidev", listMock[0])
        assertEquals("dev", listMock[1])
        assertEquals("sam", listMock[2])

        println(listMock[0])
        println(listMock[1])
        println(listMock[2])

        // verify
        Mockito.verify(listMock, Mockito.times(3))[0]
        Mockito.verify(listMock, Mockito.times(2))[1]
        Mockito.verify(listMock, Mockito.times(2))[2]

    }


}





