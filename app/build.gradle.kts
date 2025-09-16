plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

//android {
//    namespace = "com.example.studysmart"
//    compileSdk = 36 // 35
//
//    defaultConfig {
//        applicationId = "com.example.studysmart"
//        minSdk = 26 // 35
//        targetSdk = 36 // 35
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        isCoreLibraryDesugaringEnabled = true // use java date time api
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
//    kotlinOptions {
//        jvmTarget = "17"
//    }
//    buildFeatures {
//        compose = true
//    }
//}

//dependencies {
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//
//    //
//    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.0")
////    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0-alpha02")
//
//    //compose destination
//    val destinationVersion = "1.9.52"
//    implementation("io.github.raamcosta.compose-destinations:core:$destinationVersion")
//    ksp("io.github.raamcosta.compose-destinations:ksp:$destinationVersion")
//
//    // Room
//    // Room library will be use for local storage
//    val roomVersion = "2.6.1"
//    implementation("androidx.room:room-runtime:$roomVersion")
//    ksp("androidx.room:room-compiler:$roomVersion")
//    implementation("androidx.room:room-ktx:$roomVersion")
//
//    //Dagger-Hilt
//    // Will use for dependency injection
//    implementation("com.google.dagger:hilt-android:2.51.1")
//    ksp("com.google.dagger:hilt-android-compiler:2.51.1")
//    ksp("androidx.hilt:hilt-compiler:1.2.0")
//    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
//
//    //fonts
//    // implementation("androidx.compose.ui:ui-text-google-fonts:1.9.0")
//    implementation("androidx.compose.ui:ui-text-google-fonts")
//
//    //Desugaring
//    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
//
//}



android {
    namespace = "com.example.studysmart"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.studysmart"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0-alpha02")

    //compose destination
    val destinationVersion = "1.9.52"
    implementation("io.github.raamcosta.compose-destinations:core:$destinationVersion")
    ksp("io.github.raamcosta.compose-destinations:ksp:$destinationVersion")

    // Room
    // Room library will be use for local storage
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    //Dagger-Hilt
    // Will use for dependency injection
    implementation("com.google.dagger:hilt-android:2.51.1")
    ksp("com.google.dagger:hilt-android-compiler:2.51.1")
    ksp("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //fonts
    // implementation("androidx.compose.ui:ui-text-google-fonts:1.9.0")
    implementation("androidx.compose.ui:ui-text-google-fonts")

    //Desugaring
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")

}

//
//dependencies {
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.lifecycle.runtime.compose)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    implementation(libs.androidx.ui.text.google.fonts)
//
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//
//    // Room
//    implementation(libs.androidx.room.runtime)
//    implementation(libs.androidx.room.ktx)
//    ksp(libs.androidx.room.compiler)
//
//    // Hilt
//    implementation(libs.hilt.android)
//    ksp(libs.hilt.android.compiler)
//    ksp(libs.androidx.hilt.compiler)
//    implementation(libs.androidx.hilt.navigation.compose)
//
//    // Compose Destinations (still manual, not in catalog yet)
//    val destinationVersion = "1.9.52"
//    implementation("io.github.raamcosta.compose-destinations:core:$destinationVersion")
//    ksp("io.github.raamcosta.compose-destinations:ksp:$destinationVersion")
//
//    // Desugaring
//    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
//}
