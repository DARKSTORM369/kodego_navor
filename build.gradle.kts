import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.0") // Added for Logging
    implementation("ch.qos.logback:logback-classic:1.4.4") // Added for Logging

    implementation("org.jetbrains.kotlinx:multik-core:0.2.1") // For Testing
    implementation("org.jetbrains.kotlinx:multik-default:0.2.1") // For Test
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}