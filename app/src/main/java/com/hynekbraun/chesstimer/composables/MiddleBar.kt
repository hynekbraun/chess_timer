package com.hynekbraun.chesstimer.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hynekbraun.chesstimer.R

@Composable
fun MiddleBar(
    modifier: Modifier = Modifier,
    isActive: Boolean,
    onSettingsClicked: () -> Unit,
    onPauseClicked: () -> Unit,
    onResetClicked: () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { onResetClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_refresh_24),
                    contentDescription = stringResource(
                        R.string.content_desc_reset
                    )
                )
            }
            IconButton(onClick = { onSettingsClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings_24),
                    contentDescription = stringResource(
                        R.string.content_desc_settings
                    )
                )
            }
            IconButton(onClick = { onPauseClicked() }) {
                Icon(
                    painter = if (isActive) painterResource(id = R.drawable.ic_pause_24)
                    else painterResource(id = R.drawable.ic_play_24),
                    contentDescription = stringResource(R.string.content_desc_play)
                )
            }
        }
    }
}

@Preview
@Composable
fun MiddleBarPreview() {
    MiddleBar(isActive = false, onSettingsClicked = {}, onPauseClicked = {}, onResetClicked = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}