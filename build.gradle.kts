import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

group = "me.adkhambek"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {

    testImplementation("junit:junit:4.4")
    testImplementation(kotlin("test-junit"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}