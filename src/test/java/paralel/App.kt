package paralel

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit.*

@Execution(ExecutionMode.CONCURRENT)
class App {

    @Test
    @Timeout(value = 5, unit = SECONDS)
    fun testA() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = SECONDS)
    fun testB() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = SECONDS)
    fun testC() {
        Thread.sleep(3000)
    }
    @Test
    @Timeout(value = 5, unit = SECONDS)
    fun testD() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = SECONDS)
    fun testE() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = SECONDS)
    fun testF() {
        Thread.sleep(3000)
    }

}