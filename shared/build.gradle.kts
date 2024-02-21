import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization")
    alias(libs.plugins.sqldelight)
}

val testFrameworkAttribute = Attribute.of("com.example.testFramework", String::class.java)
kotlin {
//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs {
//       browser()
//    }
    js(IR) {
        browser()
    }
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

//    macosX64()
//    macosArm64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
//    watchosArm64()
//    tvosArm64()

    jvm()

//    jvm("junit") {
//        attributes.attribute(testFrameworkAttribute, "junit")
//    }
//    jvm("testng") {
//        attributes.attribute(testFrameworkAttribute, "testng")
//    }

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation(libs.kotlinx.coroutine)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.negotiation)
            implementation(libs.ktor.json)
            implementation(libs.sqldelight.runtime)
            implementation(libs.kotlinx.datetime)
        }

        androidMain.dependencies {
            //Recommend declaring Android dependencies here
            implementation(libs.ktor.client.android)
            implementation(libs.sqldelight.android)
            implementation("androidx.sqlite:sqlite-framework:2.4.0")
        }

        jvmMain.dependencies {
            configurations.all {
                exclude(module = "slf4j-log4j12")
            }
            implementation(libs.google.guava)
            implementation(libs.kotlinx.coroutine.jvm)
            implementation(libs.ktor.client.cio)
            implementation(libs.sqldelight.jvm)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqldelight.native)
        }

        jsMain.dependencies {
            implementation(libs.ktor.client.js)
            implementation(libs.sqldelight.js)
            implementation("app.cash.sqldelight:web-worker-driver:2.0.1")
            implementation(npm("sql.js", "1.6.2"))
            implementation(devNpm("copy-webpack-plugin", "9.1.0"))
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

//        kotlin.mpp.applyDefaultHierarchyTemplate=false
//        val jvmAndJsMain by creating {
//            dependsOn(commonMain.get())
//        }
//
//        jvmMain {
//            dependsOn(jvmAndJsMain)
//        }

//        jsMain {
//            dependsOn(jvmAndJsMain)
//        }
    }
}

android {
    namespace = "org.example.project.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
//    dependencies {
//         In case the top-level dependency had non-trivial configuration name, put Android dependency here
//    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.example.cache")
//            generateAsync.set(true)
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:+")
}
