buildscript {
    val safeExtGet by extra {
        fun(prop: String, fallback: Any): Any? {
            return when (rootProject.extra.has(prop)) {
                true -> rootProject.extra.get(prop)
                else -> fallback
            }
        }
    }

    val kotlin_version = safeExtGet("kotlinVersion", "1.6.10")

    repositories {
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath(kotlin("gradle-plugin", version = "$kotlin_version"))
    }
}

fun isNewArchitectureEnabled(): Boolean {
    if (!project.hasProperty("newArchEnabled")) {
        return false
    }
    val newArchEnabled: String by project
    return newArchEnabled == "true"
}

plugins {
    id("com.android.library")
    id("kotlin-android")
}
if (isNewArchitectureEnabled()) {
    apply(plugin = "com.facebook.react")
}

android {
    val safeExtGet: (prop: String, fallback: Any) -> Any? by project.extra

    compileSdk = safeExtGet("compileSdkVersion", 33) as Int?

    namespace = "com.conicgradientpackage"

    defaultConfig {
        minSdk = safeExtGet("minSdkVersion", 21) as Int?
        targetSdk = safeExtGet("targetSdkVersion", 33) as Int?
        buildConfigField("boolean", "IS_NEW_ARCHITECTURE_ENABLED", isNewArchitectureEnabled().toString())
    }

    sourceSets {
        named("main") {
            if (isNewArchitectureEnabled()) {
                java.srcDirs(listOf("src/newarch/java", "${project.buildDir}/generated/source/codegen/java"))
            } else {
                java.srcDirs(listOf("src/oldarch/java"))
            }
        }
    }
}

repositories {
    maven(
        "$projectDir/../node_modules/react-native/android"
    )
    mavenCentral()
    google()
}

apply(from = "$projectDir/react-native-helpers.gradle.kts")

val shouldConsumeReactNativeFromMavenCentral: () -> Boolean by project.extra

dependencies {
    if (shouldConsumeReactNativeFromMavenCentral()) {
        implementation("com.facebook.react:react-android") // Set by the React Native Gradle Plugin
    } else {
        implementation("com.facebook.react:react-native:+") // From node_modules
    }
}
