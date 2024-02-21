package com.example.search


actual fun determineCurrentRuntime(): CurrentRuntime {
    val name = "js"

    return CurrentRuntime(name, null)
}