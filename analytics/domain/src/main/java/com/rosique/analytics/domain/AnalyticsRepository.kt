package com.rosique.analytics.domain

interface AnalyticsRepository {

    suspend fun getAnalyticsValues(): AnalyticsValues
}