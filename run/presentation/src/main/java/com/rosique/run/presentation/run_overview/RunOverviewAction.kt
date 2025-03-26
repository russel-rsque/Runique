package com.rosique.run.presentation.run_overview

sealed interface RunOverviewAction {
    data object OnStartCLick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
}