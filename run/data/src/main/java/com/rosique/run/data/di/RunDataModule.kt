package com.rosique.run.data.di

import com.rosique.run.data.CreateRunWorker
import com.rosique.run.data.DeleteRunWorker
import com.rosique.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}