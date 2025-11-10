package com.rosique.run.presentation.run_overview

import com.rosique.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList<RunUi>()
)
