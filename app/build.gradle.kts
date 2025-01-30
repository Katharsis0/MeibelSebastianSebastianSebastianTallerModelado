plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.registro"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.registro"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    testImplementation(libs.junit)  // JUnit 4
    androidTestImplementation(libs.ext.junit)  // AndroidX Test - JUnit
    androidTestImplementation(libs.espresso.core)  // Espresso
    androidTestImplementation(libs.test.runner)  // AndroidX Test Runner
    androidTestImplementation(libs.test.rules)  // AndroidX Test Rules
    androidTestImplementation(libs.test.core)  // AndroidX Test Core
    androidTestImplementation(libs.mockito.android)  // Mockito para Android
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation ("com.google.android.material:material:1.9.0")  //Material Icons library
    implementation ("com.google.android.gms:play-services-auth:21.3.0")
    implementation("com.google.android.gms:play-services-maps:19.0.0")
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}