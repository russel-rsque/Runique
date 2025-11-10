package com.rosique.runique

import android.app.Application
import com.rosique.auth.data.di.authDataModule
import com.rosique.auth.presentation.di.authViewModelModule
import com.rosique.core.data.di.coreDateModule
import com.rosique.core.database.di.databaseModule
import com.rosique.run.data.di.runDataModule
import com.rosique.run.location.di.locationModule
import com.rosique.run.network.di.networkModule
import com.rosique.run.presentation.di.runPresentationModule
import com.rosique.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDateModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}