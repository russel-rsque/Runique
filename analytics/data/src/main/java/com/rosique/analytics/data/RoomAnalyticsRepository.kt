package com.rosique.analytics.data

import com.rosique.analytics.domain.AnalyticsRepository
import com.rosique.analytics.domain.AnalyticsValues
import com.rosique.core.database.dao.AnalyticsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

class RoomAnalyticsRepository(
    private val analyticsDao: AnalyticsDao
): AnalyticsRepository {

    override suspend fun getAnalyticsValues(): AnalyticsValues {
        return withContext(Dispatchers.IO) {
            val totalDistanceMeters = async { analyticsDao.getTotalDistanceMeters() }
            val totalTimeMillis = async { analyticsDao.getTotalTimeRun() }
            val maxRunSpeed = async { analyticsDao.getMaxRunSpeed() }
            val avgDistancePerRun = async { analyticsDao.getAvgDistancePerRun() }
            val avgPacePerRun = async { analyticsDao.getAvgPacePerRun() }

            AnalyticsValues(
                totalDistanceRun = totalDistanceMeters.await(),
                totalTimeRun = totalTimeMillis.await().milliseconds,
                fastestEverRun = maxRunSpeed.await(),
                avgDistanceRun = avgDistancePerRun.await(),
                avgPacePerRun = avgPacePerRun.await()
            )
        }
    }
}