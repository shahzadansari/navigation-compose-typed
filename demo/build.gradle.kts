@file:Suppress("UnstableApiUsage")

plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
	id("org.jetbrains.kotlin.plugin.serialization")
	id("org.jmailen.kotlinter")
}

android {
	namespace = "com.kiwi.navigationcompose.typed.demo"

	compileSdk = libs.versions.compileSdk.get().toInt()

	defaultConfig {
		applicationId = "com.kiwi.navigationcompose.typed.demo"
		minSdk = 26
		targetSdk = 33
		versionName = "1.0.0"
		versionCode = 1
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildFeatures {
		compose = true
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	composeOptions {
		kotlinCompilerExtensionVersion = libs.compose.compiler.get().version
	}

	buildFeatures {
		compose = true
		buildConfig = false
		aidl = false
		renderScript = false
		resValues = false
		shaders = false
	}

	kotlinOptions {
		freeCompilerArgs = freeCompilerArgs.toMutableList().apply {
			add("-Xexplicit-api=strict")
		}.toList()
	}

	lint {
		abortOnError = true
		warningsAsErrors = true
	}
}

kotlinter {
	reporters = arrayOf("json")
	experimentalRules = true
}

dependencies {
	implementation(projects.core)

	implementation(libs.kotlin.stdlib)
	implementation(libs.kotlin.serialization)
	implementation(libs.compose.material)
	implementation(libs.compose.navigation)
}
