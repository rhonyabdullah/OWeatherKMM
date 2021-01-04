/**
 * Project OWeatherKMM.
 *
 * Created by Rhony on 11/16/20.
 */
class Deps {

    object Android {
        const val compileSdk = 30
        const val targetSdk = 30
        const val minSdk = 16
    }

    object Versions {
        const val kotlin = "1.4.21"
        const val sqlDelight = "1.4.4"
        internal const val kotlinxSerialization = "1.0.1"
        internal const val kodeinDi = "7.1.0"
        internal const val coroutines = "1.4.2-native-mt"
        internal const val ktorClient = "1.5.0"
        internal const val mokoMvvm = "0.8.1"
        internal const val lifecycleAndroid = "2.2.0"
        internal const val mokoResources = "0.13.2"
        internal const val mokoGraphics = "0.5.0"
        internal const val mokoParcelize = "0.5.0"
    }

    object Plugins {
        val androidLibrary = GradlePlugin(id = "com.android.library")
        val kotlinAndroidExtensions = GradlePlugin(id = "kotlin-android-extensions")
        val kotlinMultiplatform = GradlePlugin(
            id = "org.jetbrains.kotlin.multiplatform",
            module = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        )
        val mobileMultiplatform = GradlePlugin(id = "dev.icerock.mobile.multiplatform")
        val iosFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.ios-framework")
        val kotlinSerialization = GradlePlugin(
            id = "org.jetbrains.kotlin.plugin.serialization",
            module = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
        )
        val sqlDelight = GradlePlugin(
            id = "com.squareup.sqldelight",
            module = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
        )
        val mokoResources = GradlePlugin(
            id = "dev.icerock.mobile.multiplatform-resources",
            module = "dev.icerock.moko:resources-generator:${Versions.mokoResources}"
        )
    }

    class Libs {
        object MultiPlatform {
            val ktorClient = MultiPlatformLibrary(
                common = "io.ktor:ktor-client-core:${Versions.ktorClient}",
                android = "io.ktor:ktor-client-android:${Versions.ktorClient}",
                iosX64 = "io.ktor:ktor-client-core-iosx64:${Versions.ktorClient}",
                iosArm64 = "io.ktor:ktor-client-core-iosarm64:${Versions.ktorClient}",
            )
            const val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.ktorClient}"
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
            const val kodeinDi = "org.kodein.di:kodein-di:${Versions.kodeinDi}"
            val sqlDelight = MultiPlatformLibrary(
                common = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}",
                android = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}",
                iosX64 = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}",
                iosArm64 = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
            )
            val mokoMvvm = MultiPlatformLibrary(
                common = "dev.icerock.moko:mvvm:${Versions.mokoMvvm}",
                iosX64 = "dev.icerock.moko:mvvm-iosx64:${Versions.mokoMvvm}",
                iosArm64 = "dev.icerock.moko:mvvm-iosarm64:${Versions.mokoMvvm}"
            )
            val mokoResources = MultiPlatformLibrary(
                common = "dev.icerock.moko:resources:${Versions.mokoResources}",
                iosX64 = "dev.icerock.moko:resources-iosx64:${Versions.mokoResources}",
                iosArm64 = "dev.icerock.moko:resources-iosarm64:${Versions.mokoResources}"
            )
            const val mokoGraphics = "dev.icerock.moko:graphics:${Versions.mokoGraphics}"
            const val mokoParcelize = "dev.icerock.moko:parcelize:${Versions.mokoParcelize}"
        }
        object Android {
            const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleAndroid}"
        }
    }


}