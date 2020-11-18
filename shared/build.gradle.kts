//import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiplatform)
    plugin(Deps.Plugins.mobileMultiplatform)
    plugin(Deps.Plugins.iosFramework)
    plugin(Deps.Plugins.kotlinAndroidExtensions)
    plugin(Deps.Plugins.kotlinSerialization)
    plugin(Deps.Plugins.sqlDelight)
}

kotlin {
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) iosArm64("ios")
    else iosX64("ios")

    sourceSets {
        val commonMain by getting {
            resources.srcDir("src/commonMain/sqldelight")
        }
    }
}

dependencies {
    //region common
    commonMainImplementation(Deps.Libs.MultiPlatform.coroutines)

    mppLibrary(Deps.Libs.MultiPlatform.ktorClient)
    commonMainImplementation(Deps.Libs.MultiPlatform.ktorClientLogging)

    commonMainImplementation(Deps.Libs.MultiPlatform.kotlinSerialization)

    commonMainImplementation(Deps.Libs.MultiPlatform.kodeinDi)

    mppLibrary(Deps.Libs.MultiPlatform.sqlDelight)

    commonMainImplementation(Deps.Libs.MultiPlatform.mokoMvvm)
    commonMainImplementation(Deps.Libs.MultiPlatform.mokoResources)
    commonMainImplementation(Deps.Libs.MultiPlatform.mokoGraphics)
    commonMainImplementation(Deps.Libs.MultiPlatform.mokoParcelize)
    //endregion

    //region android
    androidMainImplementation(Deps.Libs.Android.lifecycle)
    //endregion

    //region ios
    ///actual NativeSqliteDriver somehow not found on iosMain package
    iosMainApi(Deps.Libs.MultiPlatform.sqlDelight.iosX64.toString())
    //endregion
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.rnd.oweatherkmm"
    }
}

// optional for export dependencies into framework header
framework {
//    export(project = project(":myproject"))
//    export(kotlinNativeExportable = MultiPlatfomLibrary(<...>))
//    export(kotlinNativeExportable = MultiPlatfomModule(<...>))
//    export(arm64Dependency = "my.group:name-iosarm64:0.1.0", x64Dependency = "my.group:name-iosx64:0.1.0")
}

cocoaPods {
    podsProject = file("../ios/Pods/Pods.xcodeproj") // here should be path to your Pods project
//    buildConfiguration = "dev-debug" // optional, default is "debug"

//    pod("MBProgressHUD") // create cInterop and link with CocoaPod where schema and module is same
//    pod(schema = "moko-widgets-flat", module = "mokoWidgetsFlat") // create cInterop and link with CocoaPod where schema and module is different
//    pod(schema = "moko-widgets-flat", module = "mokoWidgetsFlat", onlyLink = true) // not create cInterop - just link framework with this CocoaPod
}

/*
kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.0")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.12")
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}
android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)*/
