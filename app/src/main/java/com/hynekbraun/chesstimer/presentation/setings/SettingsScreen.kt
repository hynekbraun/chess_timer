package com.hynekbraun.chesstimer.presentation.setings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hynekbraun.chesstimer.R
import com.hynekbraun.chesstimer.domain.TimeModel
import com.hynekbraun.chesstimer.presentation.setings.composables.EmptyScreen
import com.hynekbraun.chesstimer.presentation.setings.composables.TimeItem
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    timeList: List<TimeModel> = emptyList(),
    viewModel: SettingsViewModel = viewModel(),
    addTimerClicked: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier, scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {addTimerClicked()}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.content_desc_add_time)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        if (timeList.isEmpty()) {
            EmptyScreen()
        } else {
            LazyColumn {
                items(timeList) { time ->
                    TimeItem(time = time) {
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    val dummyList = listOf(
        TimeModel(0, "asdasd", 0L, 0L),
        TimeModel(0, "asdasd", 0L, 0L),
        TimeModel(0, "asdasd", 0L, 0L),
        TimeModel(0, "asdasd", 0L, 0L),
        TimeModel(0, "asdasd", 0L, 0L),
        TimeModel(0, "asdasd", 0L, 0L),
        TimeModel(0, "asdasd", 0L, 0L),
    )
    Surface(modifier = Modifier.fillMaxSize()) {
        SettingsScreen(timeList = dummyList, addTimerClicked = {})
    }
}

