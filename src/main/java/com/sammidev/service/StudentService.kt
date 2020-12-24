package com.sammidev.service

import com.sammidev.entity.Student
import com.sammidev.repository.StudentRepository

class StudentService : StudentRepository{

    var student = mutableListOf<Student>()

    override fun saveStudent(student: Student): Boolean {
        this.student.add(student)
        return true
    }

    override fun findAllStudent(): List<Student> = this.student

    override fun findStudentById(id: Long): Student? {
        student.forEach { i ->
            if (i.id == id) {
                val idStudent: Long = id - 1
                return this.student[idStudent.toInt()]
            }
        }
        return null
    }

    override fun updateStudent(id: Long, studentParam: Student): Boolean {

        val student = findStudentById(id)
        if (student != null) {
            student.id = studentParam.id
            student.name = studentParam.name
            student.nim = studentParam.nim
        }
        val studentTemp = this.student[id.toInt()]
        if (studentTemp != null) {
            this.student[id.toInt()] = studentTemp
            return true
        }
        return false
    }

    override fun deleteStudentById(id: Long): Boolean {
        val student = findStudentById(id) ?: return false
        this.student.removeAt((id-1).toInt())
        return true
    }

    override fun deleteStudent(student: Student): Boolean {
        this.student.remove(student)
        return true
    }
}