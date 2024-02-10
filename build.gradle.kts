buildscript {
    repositories {
        google()
        mavenCentral()

    }
    dependencies {
        classpath ("com.android.tools.build:gradle:3.6.4")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
        classpath ("com.google.gms:google-services:4.4.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}