package com.hynekbraun.chesstimer.presentation.setings

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hynekbraun.chesstimer.R
import com.hynekbraun.chesstimer.presentation.composables.CustomTopAppBar
import com.hynekbraun.chesstimer.presentation.setings.composables.EmptyScreen
import com.hynekbraun.chesstimer.presentation.setings.composables.TimeItem
import com.hynekbraun.chesstimer.presentation.setings.util.SettingsEvent

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = viewModel(),
    addTimerClicked: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.viewState

    Scaffold(
        modifier = modifier, scaffoldState = scaffoldState,
        topBar = {
            CustomTopAppBar(
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false)
                ) {
                    addTimerClicked()
                },
                onNavigateBack = { onNavigateBack() }, showAddTimer = true
            )
        }
    ) {
        if (state.list.isEmpty()) {
            EmptyScreen()
        } else {
            LazyColumn {
                items(state.list) { time ->
                    TimeItem(
                        time = time, onDelete = {
                            viewModel.onEvent(SettingsEvent.OnDelete(time.id))
                        },
                        isSelected = time == state.selectedItem,
                        onSelected = { viewModel.onEvent(SettingsEvent.OnTimeSelected(time.id)) }
                    )

                }
            }
        }
    }
}