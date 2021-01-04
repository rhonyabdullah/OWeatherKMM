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
    sourceSets.getByName("commonMain") {
        resources.srcDir("src/commonMain/sqldelight")
    }

    // https://github.com/cashapp/sqldelight/issues/1442
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.all {
            linkerOpts.add("-lsqlite3")
        }
    }
}

dependencies {
    //region common
    commonMainImplementation(Deps.Libs.MultiPlatform.coroutines) {
        // we should force native-mt version for ktor 1.4.0 on iOS
        isForce = true
    }

    mppLibrary(Deps.Libs.MultiPlatform.ktorClient)
    commonMainImplementation(Deps.Libs.MultiPlatform.ktorClientLogging)

    commonMainImplementation(Deps.Libs.MultiPlatform.kotlinSerialization)

    commonMainImplementation(Deps.Libs.MultiPlatform.kodeinDi)

    mppLibrary(Deps.Libs.MultiPlatform.sqlDelight)

    commonMainApi(Deps.Libs.MultiPlatform.mokoMvvm.common)
    commonMainApi(Deps.Libs.MultiPlatform.mokoResources.common)
    commonMainImplementation(Deps.Libs.MultiPlatform.mokoGraphics)
    commonMainImplementation(Deps.Libs.MultiPlatform.mokoParcelize)
    //endregion

    //region android
    androidMainImplementation(Deps.Libs.Android.lifecycle)
    //endregion

    //region ios
    //endregion
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.rnd.oweatherkmm"
    }
}

// optional for export dependencies into framework header
framework {
    export(Deps.Libs.MultiPlatform.mokoMvvm)
    export(Deps.Libs.MultiPlatform.mokoResources)
}

cocoaPods {
    podsProject = file("../ios/Pods/Pods.xcodeproj") // here should be path to your Pods project
}
