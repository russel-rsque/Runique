package com.rosique.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}