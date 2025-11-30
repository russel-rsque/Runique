@file:OptIn(ExperimentalMaterial3Api::class)

package com.rosique.analytics.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rosique.analytics.presentation.components.AnalyticsCard
import com.rosique.core.presentation.designsystem.RuniqueTheme
import com.rosique.core.presentation.designsystem.components.RuniqueScaffold
import com.rosique.core.presentation.designsystem.components.RuniqueToolbar
import org.koin.androidx.compose.koinViewModel

@Composable

fun AnalyticsDashboardScreenRoot(
    viewModel: AnalyticsDashboardViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {

    AnalyticsDashboardScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                AnalyticsAction.OnBackClick -> onBackClick()
            }
        }
    )
}

@Composable
private fun AnalyticsDashboardScreen(
    state: AnalyticsDashboardState?,
    onAction: (AnalyticsAction) -> Unit
) {

    RuniqueScaffold(
        topAppBar = {
            RuniqueToolbar(
                showBackButton = true,
                title = stringResource(R.string.analytics),
                onBackClick = { onAction(AnalyticsAction.OnBackClick) }
            )
        }
    ) { innerPadding ->
        if (state == null) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AnalyticsCard(
                        title = stringResource(R.string.total_distance_run),
                        value = state.totalDistanceRun,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        title = stringResource(R.string.total_time_run),
                        value = state.totalTimeRun,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AnalyticsCard(
                        title = stringResource(R.string.fastest_ever_run),
                        value = state.fastestEverRun,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        title = stringResource(R.string.highest_heart_rate),
                        value = "",
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AnalyticsCard(
                        title = stringResource(R.string.avg_distance_per_run),
                        value = state.avgDistance,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        title = stringResource(R.string.avg_pace_per_run),
                        value = state.avgPace,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AnalyticsDashboardScreenPreview() {
    RuniqueTheme {
        AnalyticsDashboardScreen(
            state = AnalyticsDashboardState(
                totalDistanceRun = "142.3 km",
                totalTimeRun = "0d 17h 54m",
                fastestEverRun = "51 km/h",
                avgDistance = "6.2 km",
                avgPace = "7:10"
            ),
            onAction = {}
        )
    }
}