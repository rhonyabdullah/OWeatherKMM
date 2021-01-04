package com.rnd.oweatherkmm.data.source.cache

import com.rnd.oweatherkmm.AppDatabase
import com.rnd.oweatherkmm.BuildConfig
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

/**
 * Project OWeatherKMM.
 *
 * Created by Rhony on 11/17/20.
 */
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "${BuildConfig.packageName}.db")
    }
}
