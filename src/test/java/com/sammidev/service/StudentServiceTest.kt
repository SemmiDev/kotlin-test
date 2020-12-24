package com.sammidev.service

import com.sammidev.entity.Student
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StudentServiceTest {

    val studentService = StudentService()

    @BeforeEach
    fun setUp() {
        val studens = listOf<Student>(
                Student(1,"sammi","200311"),
                Student(2,"sammi2","200312"),
                Student(3,"sammi3","200313"),
                Student(4,"sammi4","200314")
        )
        for (i in 0..3) {
            studentService.saveStudent(studens.get(i))
        }
    }

    @Test
    fun testSaveStudentSuccess() {
        val student = Student(5,"sammidev","2003113928")
        assertEquals(true, StudentService().saveStudent(student))
    }

    @Test
    fun testFindAllStudent() {
        val allStudent = studentService.findAllStudent()
        assertEquals(4, allStudent.size)
    }

    @Test
    fun testFindStudentById() {
        val student = studentService.findStudentById(2)
        val studentResultExpected = studentService.findAllStudent()[1]
        assertEquals(studentResultExpected, student)
    }

    @Test
    fun testUpdateStudent() {
        val student = studentService.findStudentById(1)
        val studentUpdate = Student(10, "sammiUpdated", "2003113928")
        val studentUpdateServiceResult = studentService.updateStudent(student!!.id, studentUpdate)

        assertEquals(true, studentUpdateServiceResult)
        assertEquals(studentUpdate.name, studentUpdate.name)
        this.studentService.findAllStudent().forEach {
            println(it)
        }
    }

    @Test
    fun testDeleteStudentById() {
        this.studentService.findAllStudent().forEach {
            println(it)
        }
        println("------")

        val test = this.studentService.deleteStudentById(1)
        assertEquals(true, test)

        println("------")
        this.studentService.findAllStudent().forEach {
            println(it)
        }
    }

    @Test
    fun testDeleteStudentByStudent() {
        val student = Student(1,"sammi","200311")
        val tempStatus =  this.studentService.deleteStudent(student)
        assertEquals(true,tempStatus)

        this.studentService.findAllStudent().forEach {
            println(it)
        }
    }
}