package com.hynekbraun.chesstimer.presentation.setings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hynekbraun.chesstimer.R
import com.hynekbraun.chesstimer.presentation.composables.CustomTopAppBar
import com.hynekbraun.chesstimer.presentation.setings.composables.EmptyScreen
import com.hynekbraun.chesstimer.presentation.setings.composables.TimeItem
import com.hynekbraun.chesstimer.presentation.setings.util.SettingsEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = viewModel(),
    addTimerClicked: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.viewState
    val context = LocalContext.current

    LaunchedEffect(key1 = 1) {
        viewModel.toastFlow.collectLatest {
            val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                it.asString(context),
                actionLabel = context.getString(R.string.undo)
            )
            when (snackbarResult) {
                SnackbarResult.Dismissed -> {}
                SnackbarResult.ActionPerformed ->
                    viewModel.onEvent(SettingsEvent.UndoDelete)
            }
        }
    }

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