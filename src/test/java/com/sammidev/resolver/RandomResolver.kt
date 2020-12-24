package com.sammidev.resolver

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import java.util.*

class RandomResolver : ParameterResolver {

    val number: Random = Random()

    override fun supportsParameter(p0: ParameterContext, p1: ExtensionContext): Boolean {
        return p0.parameter.type == Random::class.java
    }

    override fun resolveParameter(p0: ParameterContext?, p1: ExtensionContext?): Any {
        return number
    }

}