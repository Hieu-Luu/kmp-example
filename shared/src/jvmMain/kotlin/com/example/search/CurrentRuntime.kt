package com.example.search

actual fun determineCurrentRuntime(): CurrentRuntime {
    val name = System.getProperty("java.vm.name") ?: "jvm"
    val version = System.getProperty("java.version")

    return CurrentRuntime(name, version)
}