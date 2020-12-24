package com.sammidev.repository

import com.sammidev.entity.Student

interface StudentRepository {
    fun saveStudent(student: Student): Boolean
    fun findAllStudent(): List<Student>
    fun findStudentById(id: Long): Student?
    fun updateStudent(id: Long, student: Student): Boolean
    fun deleteStudentById(id: Long): Boolean
    fun deleteStudent(student: Student): Boolean
}