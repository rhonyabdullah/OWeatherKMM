package com.rnd.oweatherkmm.data.source.cache

import com.squareup.sqldelight.db.SqlDriver

/**
 * Project OWeatherKMM.
 *
 * Created by Rhony on 11/17/20.
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
