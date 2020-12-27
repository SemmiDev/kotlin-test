package confsummary

import com.sammidev.Application
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class App {

    @Nested
    inner class IsSquare {
        @Test
        fun `number is square success`() {
            val test = Application().isSquare(16)
            assertTrue { test }
        }

        @Test
        fun `number is not square success`() {
            val test = Application().isSquare(5)
            assertFalse { test }
        }
    }

    @Nested
    inner class Calculator {
        @Test
        fun `test name`() {
        }
    }

}