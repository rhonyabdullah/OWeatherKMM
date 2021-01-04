/**
 * Any kotlin version used here is tied to [Deps.Versions.kotlin] so don't forget to change
 */
plugins {
    id("org.jetbrains.kotlin.jvm") version("1.4.21")
}

repositories {
    jcenter()
    google()

    maven { url = uri("https://dl.bintray.com/icerockdev/plugins") }
}

dependencies {
    implementation("com.android.tools.build:gradle:4.0.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
    implementation("dev.icerock:mobile-multiplatform:0.9.0")
}
