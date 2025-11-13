package com.rosique.run.data.di

import com.rosique.core.domain.run.SyncRunScheduler
import com.rosique.run.data.CreateRunWorker
import com.rosique.run.data.DeleteRunWorker
import com.rosique.run.data.FetchRunsWorker
import com.rosique.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}