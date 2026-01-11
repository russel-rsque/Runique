package com.rosique.wear.app.presentation.di

import com.rosique.wear.app.presentation.RuniqueApp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single {
        (androidApplication() as RuniqueApp)
            .applicationScope
    }
}