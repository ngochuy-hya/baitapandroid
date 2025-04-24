plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.webviewclient"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.webviewclient"
        minSdk = 24
        targetSdk = 35
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Thêm thư viện cho WebView
    implementation("androidx.webkit:webkit:1.9.0") // Thư viện WebKit mới nhất

    // Thư viện xử lý mạng (nếu cần)
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Debug implementation
    debugImplementation("com.facebook.stetho:stetho:1.6.0") // Debug network
}