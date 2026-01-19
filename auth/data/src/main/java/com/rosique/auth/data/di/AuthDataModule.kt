package com.rosique.auth.data.di

import com.rosique.auth.data.AuthRepositoryImpl
import com.rosique.auth.data.EmailPatternValidator
import com.rosique.auth.domain.AuthRepository
import com.rosique.auth.domain.PatternValidator
import com.rosique.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}