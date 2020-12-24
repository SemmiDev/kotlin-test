package com.sammidev.inheritance

import com.sammidev.entity.Student
import com.sammidev.resolver.StudentResolver
import com.sammidev.service.StudentService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
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

