package com.rosique.core.data.di

import com.rosique.core.data.auth.EncryptedSessionStorage
import com.rosique.core.data.networking.HttpClientFactory
import com.rosique.core.data.run.OfflineFirstRunRepository
import com.rosique.core.domain.SessionStorage
import com.rosique.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDateModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}