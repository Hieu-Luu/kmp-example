package com.example.search

import kotlin.test.Test
import kotlin.test.assertEquals

class IOSRuntimeTest {
    @Test
    fun shouldDetectOS() {
        val runtime = determineCurrentRuntime()
        assertEquals(runtime.name, "ios")
        assertEquals(runtime.version, "unknown")
    }
}