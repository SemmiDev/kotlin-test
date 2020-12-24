package com.sammidev.resolver

import com.sammidev.entity.Student
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver

class StudentResolver : ParameterResolver {

    private val student: Student = Student(1,"Sammi Aldhi Yanto","2003113948")

    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean {
        return parameterContext.parameter.type == Student::class.java
    }

    override fun resolveParameter(p0: ParameterContext?, p1: ExtensionContext?): Any {
        return student
    }

}