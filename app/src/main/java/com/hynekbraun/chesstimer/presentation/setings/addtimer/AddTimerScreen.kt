package com.hynekbraun.chesstimer.presentation.setings.addtimer

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
    viewModel: AddTimerViewModel = viewModel()
) {
    var text by remember {
        mutableStateOf("")
    }
    val viewState = viewModel.timerState
    Column(modifier = modifier.padding(8.dp)) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
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
    }
}

@Preview
@Composable
fun AddTimerScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        AddTimerScreen()
    }
}