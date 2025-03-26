@file:OptIn(ExperimentalMaterial3Api::class)

package com.rosique.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rosique.core.presentation.designsystem.AnalyticsIcon
import com.rosique.core.presentation.designsystem.LogoIcon
import com.rosique.core.presentation.designsystem.LogoutIcon
import com.rosique.core.presentation.designsystem.RunIcon
import com.rosique.core.presentation.designsystem.RuniqueTheme
import com.rosique.core.presentation.designsystem.components.RuniqueFloatingActionButton
import com.rosique.core.presentation.designsystem.components.RuniqueScaffold
import com.rosique.core.presentation.designsystem.components.RuniqueToolbar
import com.rosique.core.presentation.designsystem.components.util.DropDownItem
import org.koin.androidx.compose.koinViewModel
import com.rosique.run.presentation.R

@Composable

fun RunOverviewScreenRoot(
    viewModel: RunOverviewViewModel = koinViewModel()
) {

    RunOverviewScreen(
        onAction = viewModel::onAction
    )
}

@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {

    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )

    RuniqueScaffold(
        topAppBar = {
            RuniqueToolbar(
                showBackButton = false,
                title = stringResource(R.string.runique),
                scrollBehavior = scrollBehavior,
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(R.string.logout)
                    )
                ),
                onClickMenuItem = { index ->
                    when(index) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                }
            )
        },
        floatingActionButton = {
            RuniqueFloatingActionButton(
                icon = RunIcon,
                onClick = {
                    onAction(RunOverviewAction.OnStartCLick)
                }
            )
        }
    ) {

    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RuniqueTheme {
        RunOverviewScreen(
            onAction = {}
        )
    }

}