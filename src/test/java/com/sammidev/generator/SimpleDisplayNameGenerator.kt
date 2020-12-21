package com.sammidev.generator

import org.junit.jupiter.api.DisplayNameGenerator
import java.lang.reflect.Method

class SimpleDisplayNameGenerator : DisplayNameGenerator {
    override fun generateDisplayNameForClass(testClass: Class<*>?): String {
        return "Test ${testClass!!.name}"
    }

    override fun generateDisplayNameForNestedClass(nestedClass: Class<*>?): String {
        return "Test ${nestedClass!!.simpleName}"
    }

    override fun generateDisplayNameForMethod(testClass: Class<*>?, testMethod: Method?): String {
        val simpleName = testMethod!!.name.replace("_","")
        return "Test ${testClass!!.simpleName} $simpleName"
    }
}



