package com.rosique.run.presentation.run_overview

import com.rosique.run.presentation.run_overview.model.RunUi

sealed interface RunOverviewAction {
    data object OnStartCLick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
    data class DeleteRun(val runUi: RunUi): RunOverviewAction
}