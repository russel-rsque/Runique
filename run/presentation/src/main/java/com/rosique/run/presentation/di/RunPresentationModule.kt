package com.rosique.run.presentation.di

import com.rosique.run.domain.RunningTracker
import com.rosique.run.presentation.active_run.ActiveRunViewModel
import com.rosique.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}