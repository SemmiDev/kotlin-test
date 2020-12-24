package com.sammidev

import com.sammidev.entity.Student
import com.sammidev.generator.SimpleDisplayNameGenerator
import com.sammidev.service.StudentService
import jdk.jfr.Enabled
import org.junit.jupiter.api.*
import org.opentest4j.TestAbortedException
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import org.junit.jupiter.api.Assumptions.*
import org.junit.jupiter.api.condition.*
import java.lang.System.getenv
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
    @Disabled("COMING SOON")
    fun testIsSquareError() {
        assertEquals(false, Application().isSquare(16))
    }
}

@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun testMultiply() {
        assertEquals(4, calculator.multiply(2,2))
    }

    @Test
    fun testModulo() {
        assertEquals(0, calculator.modulo(10,2))
    }

}

class beforeafterEach() {

    companion object {

        @JvmStatic
        @BeforeAll
        fun connectToDB() {
            println("CONNECTING...")
            println("CONNECTED...")
        }

        @JvmStatic
        @AfterAll
        fun closeDB() {
            println("DISCONNECTED...")
        }

    }

    @BeforeEach
    fun first(){
        println("first")
    }

    @Test
    fun faktorialSucces() {
        val factorial = Others().factorial(5)
        assertEquals(120, factorial)
    }

    @AfterEach
    fun last(){
        println("last")
    }

}

class Other {

    @Test
    fun testAborted() {
        val profile = getenv()["NAME"]
        if ("SAMMI" != profile) {
            throw TestAbortedException()
        }

        println("DI EKSEKUSI KETIKA SAMMI == {PROFILE}")
    }

    // ! -> return TestAbortedException
    @Test
    fun testAsumption() {
        // harus true

        assumeTrue("SAMMI" == getenv()["NAME"])
        // harus false
        // assumeFalse(blablalbalbla)
    }
}
//
//class TestBerdasarkanKondisi(){
//
//    @Test
//    @Disabled
//    fun printSystemProperties() {
//        System.getProperties().forEach {
//            t, u ->
//            println(t + " : " + u)
//        }
//    }
//
//
//    @Test
//    @Disabled
//    @EnabledIfSystemProperties(value = [
//        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
//    ])
//    fun testSystemproperties() {
//
//    }
//}


@TestMethodOrder(value = MethodOrderer.Alphanumeric::class)
class OrdererTest {
    companion object {
        val studentService = StudentService()

        @JvmStatic
        @BeforeAll
        fun setup() {

            val studentList = listOf<Student>(
                    Student(1, "sammidev", "001"),
                    Student(2, "sammidev", "002"),
                    Student(3, "sammidev", "003"),
                    Student(4, "sammidev", "004")
            )
            studentList.map {
                studentService.saveStudent(it)
            }
        }
    }

    @Test
    @Order(3)
    fun testA() {
        println(studentService.findStudentById(3))
    }

    @Test
    @Order(1)
    fun testB() {
        println(studentService.findStudentById(1))
    }

    @Test
    @Order(2)
    fun testC() {
        println(studentService.findStudentById(2))
    }

}

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class Siklus {
    // before atau after all bisa dijalankan tanpa dibungkus di companion object
    val studentService = StudentService()

    @BeforeAll
    fun create() {
        studentService.saveStudent(Student(1,"sammi","200"))
    }

    @AfterAll
    fun delete() {
        studentService.deleteStudent(Student(1,"sammi","200"))
    }

    @Test
    fun testA() {
        println(studentService.findAllStudent())
    }

    @Test
    fun testB() {
        println(studentService.findAllStudent())
    }
}

