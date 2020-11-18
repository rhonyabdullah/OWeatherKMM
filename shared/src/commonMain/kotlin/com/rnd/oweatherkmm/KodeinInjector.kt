package com.rnd.oweatherkmm

import com.rnd.oweatherkmm.data.DataInjector
import com.rnd.oweatherkmm.domain.DomainInjector
import org.kodein.di.DI

/**
 * Project OWeatherKMM.
 *
 * Created by Rhony on 11/16/20.
 */
val kodeinInjector = DI {
    importOnce(DomainInjector)
    importOnce(DataInjector)
}
