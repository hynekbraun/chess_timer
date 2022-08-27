package com.hynekbraun.chesstimer.presentation.setings.addtimer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hynekbraun.chesstimer.presentation.setings.addtimer.util.AddTimerEvent
import com.hynekbraun.chesstimer.presentation.setings.addtimer.util.AddTimerState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddTimerViewModel @Inject constructor() : ViewModel() {

    var timerState by mutableStateOf(AddTimerState())
        private set

    fun onEvent(event: AddTimerEvent){
        when(event){
            is AddTimerEvent.TimeHoursChanged -> timerState = timerState.copy(hours = event.hours)
            is AddTimerEvent.TimeMinutesChanged -> timerState = timerState.copy(minutes = event.minutes)
            is AddTimerEvent.TimeSecondsChanged -> timerState = timerState.copy(seconds = event.seconds)
            is AddTimerEvent.IncrementMinutesChanged -> timerState = timerState.copy(incrementMinutes = event.minutes)
            is AddTimerEvent.IncrementSecondsChanges -> timerState = timerState.copy(incrementSeconds = event.seconds)
        }
    }
}