package com.rnd.oweatherkmm

import platform.darwin.PLATFORM_IOS

/**
 * Project OWeatherKMM.
 *
 * Created by Rhony on 11/17/20.
 */
actual object BuildConfig {
    actual val packageName: String get() = "com.rnd.oweatherkmm.ios.${PLATFORM_IOS}"
}
