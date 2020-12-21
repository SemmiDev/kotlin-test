package com.sammidev

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class App {

    @Test
    fun testAppHasGreeting() {
        val hello = Greeting()
        assertNotNull(hello.hi("sammidev"), "hello sammidev")
    }






    

}