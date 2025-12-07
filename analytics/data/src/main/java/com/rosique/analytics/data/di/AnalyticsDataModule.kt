package com.rosique.analytics.data.di

import com.rosique.analytics.data.RoomAnalyticsRepository
import com.rosique.analytics.domain.AnalyticsRepository
import com.rosique.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsDataModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao

    }
}