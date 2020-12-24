package com.sammidev.inheritance

import com.sammidev.entity.Student
import com.sammidev.resolver.StudentResolver
import com.sammidev.service.StudentService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

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

