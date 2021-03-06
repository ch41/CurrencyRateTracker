plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.5.30"
    id("com.google.gms.google-services")
    id("dagger.hilt.android.plugin")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName


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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(Dependencies.Core.coreKtx)
    implementation(Dependencies.Core.appCompat)

    implementation(Dependencies.Design.material)
    implementation(Dependencies.Design.constraint)

    implementation(Dependencies.Lifecycle.lifecycleKtx)

    // Navigation
    implementation(Dependencies.Navigation.navFragment)
    implementation(Dependencies.Navigation.navUi)

    //Serialization
    implementation(Dependencies.Kotlin.serialization)

    //Hilt
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.navigation)
    kapt(Dependencies.Hilt.compiler)

    // Room
    implementation(Dependencies.Room.ktx)
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.paging)
    kapt(Dependencies.Room.compiler)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    implementation("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("com.google.android.material:material:1.6.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}