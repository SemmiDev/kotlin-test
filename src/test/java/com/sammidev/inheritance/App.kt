package com.sammidev.inheritance

import com.sammidev.Calculator
import com.sammidev.entity.Student
import com.sammidev.resolver.StudentResolver
import com.sammidev.service.StudentService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random
import kotlin.test.assertEquals

@Extensions(value = [
    ExtendWith(StudentResolver::class)
])
abstract class ParentStudentTest {
    val student = StudentService()

    @BeforeEach
    fun beforeEach(student: Student) {
        this.student.saveStudent(student)
        println(student)
    }
}

@Extensions(value = [
    ExtendWith(StudentResolver::class)
])
abstract class ParentRandomTest {
    val calculator = Calculator()

    @BeforeEach
    fun beforeEach() {
        println("before each")
    }
}


class StudentValueSource : ParentRandomTest() {
    @DisplayName("test calculator with parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = [10,20,30,40,50])
    fun randomParameterizedTest(value: Int) {

        val result = calculator.add(value,value)
        val result2 = calculator.multiply(value,value)

        assertEquals(value + value, result)
        assertEquals(value * value, result2)
    }

    companion object {
        @JvmStatic
        fun parameterSource(): List<Int>{
            return listOf(1,2,3,4,5,6,7,8,9,10)
        }
    }

    @ParameterizedTest
    @MethodSource(value = ["parameterSource"])
    fun testWithMethodSource(value: Int) {
        assertEquals(value+value, calculator.add(value,value))
    }
}

class RepeatedStudentTest : ParentStudentTest() {
    @DisplayName("test student")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    fun testStudent(studentParam: Student) {
        student.saveStudent(studentParam)
        assertEquals(studentParam, student.findStudentById(1))
    }
}

class App : ParentStudentTest() {

    @Test
    fun testA() {
        println(student)
    }

    @Test
    fun testB() {
        println(student)
    }
}

class App2 : ParentStudentTest() {

    @Test
    fun testA() {
        println(student)
    }

    @Test
    fun testB() {
        println(student)
    }
}

