package com.hynekbraun.chesstimer.presentation.setings.addtimer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hynekbraun.chesstimer.R
import com.hynekbraun.chesstimer.presentation.setings.addtimer.composables.TimeDesc
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hynekbraun.chesstimer.presentation.setings.addtimer.util.AddTimerEvent

@Composable
fun AddTimerScreen(
    modifier: Modifier = Modifier,
    viewModel: AddTimerViewModel = viewModel(),
    onNavigateBack: () -> Unit
) {
    val viewState = viewModel.timerState
    Column(modifier = modifier.padding(8.dp)) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewState.name,
            onValueChange = { viewModel.onEvent(AddTimerEvent.ChangeName(it)) },
            placeholder = { Text(text = stringResource(R.string.name)) },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.add_timer_screen_start_time),
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TimeDesc(
                onValueChange = { viewModel.onEvent(AddTimerEvent.TimeHoursChanged(it)) },
                value = viewState.hours,
                measurement = stringResource(R.string.hours)
            )
            TimeDesc(
                onValueChange = { viewModel.onEvent(AddTimerEvent.TimeMinutesChanged(it)) },
                value = viewState.minutes,
                measurement = stringResource(R.string.minutes)
            )
            TimeDesc(
                onValueChange = { viewModel.onEvent(AddTimerEvent.TimeSecondsChanged(it)) },
                value = viewState.seconds,
                measurement = stringResource(R.string.seconds)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.add_timer_screen_increment),
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TimeDesc(
                onValueChange = { viewModel.onEvent(AddTimerEvent.IncrementMinutesChanged(it)) },
                value = viewState.incrementMinutes,
                measurement = stringResource(R.string.minutes)
            )
            TimeDesc(
                onValueChange = { viewModel.onEvent(AddTimerEvent.IncrementSecondsChanges(it)) },
                value = viewState.incrementSeconds,
                measurement = stringResource(R.string.seconds)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.onEvent(AddTimerEvent.SaveTime)
            onNavigateBack()
        }) {
        }
    }
}

@Preview
@Composable
fun AddTimerScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        AddTimerScreen(onNavigateBack = {})
    }
}