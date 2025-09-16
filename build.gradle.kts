// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
}

buildscript {
    dependencies {
        // Hilt Gradle plugin must go here if you don’t use version catalogs
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}