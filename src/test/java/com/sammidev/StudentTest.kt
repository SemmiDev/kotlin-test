package com.sammidev

import com.sammidev.entity.Student
import com.sammidev.resolver.StudentResolver
import com.sammidev.service.StudentService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*
import kotlin.test.assertEquals

@Extensions(value = [
    ExtendWith(StudentResolver::class)
])
class StudentTest {

    private val student = StudentService()

    @Test
    fun addStudent(student: Student) {
        this.student.saveStudent(student)
        assertEquals(student, this.student.findStudentById(1))
    }
}


class TimeOut {
    @Test
    @Timeout(value = 5, unit = SECONDS)
    fun slow() {
        Thread.sleep(7000)
    }
}