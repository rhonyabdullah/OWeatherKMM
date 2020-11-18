package com.rnd.oweatherkmm.data.source.cache

import android.content.Context
import com.rnd.oweatherkmm.AppDatabase
import com.rnd.oweatherkmm.BuildConfig
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/**
 * Project OWeatherKMM.
 *
 * Created by Rhony on 11/17/20.
 */
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context, BuildConfig.packageName)
    }
}
