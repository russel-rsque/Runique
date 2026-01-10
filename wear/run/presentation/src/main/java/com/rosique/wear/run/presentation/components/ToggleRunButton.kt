package com.rosique.wear.run.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.material3.Icon
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.OutlinedIconButton
import com.rosique.core.presentation.designsystem.PauseIcon
import com.rosique.core.presentation.designsystem.StartIcon
import com.rosique.wear.run.presentation.R

@Composable
fun ToggleRunButton(
    isRunActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedIconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        if (isRunActive) {
            Icon(
                imageVector = PauseIcon,
                contentDescription = stringResource(R.string.pause_run),
                tint = MaterialTheme.colorScheme.onBackground
            )
        } else {
            Icon(
                imageVector = StartIcon,
                contentDescription = stringResource(R.string.start_run),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}