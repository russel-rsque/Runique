package com.rosique.core.data.di

import com.rosique.core.data.networking.HttpClientFactory
import org.koin.dsl.module

val coreDateModule = module {
    single {
        HttpClientFactory().build()
    }
}