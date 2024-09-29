// build.gradle (a nivel de módulo app)
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.practicanovelaseventos"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.practicanovelaseventos"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core AndroidX Components
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Activity and Compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // RecyclerView for novel list
    implementation(libs.androidx.recyclerview)

    // Room for database
    implementation(libs.androidx.room.ktx) // Room con soporte para Kotlin Coroutines
    (libs.androidx.room.compiler) // Usa KAPT en lugar de annotationProcessor para Kotlin

    // LiveData y ViewModel
    implementation(libs.androidx.lifecycle.livedata.ktx) // LiveData con soporte para Kotlin
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // ViewModel con soporte para Kotlin
    implementation(libs.androidx.lifecycle.viewmodel.savedstate) // ViewModel con estado guardado (SavedStateHandle)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debug dependencies
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
