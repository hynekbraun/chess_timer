package com.hynekbraun.chesstimer.presentation.setings.addtimer

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hynekbraun.chesstimer.presentation.setings.addtimer.util.AddTimerEvent
import com.hynekbraun.chesstimer.presentation.setings.addtimer.util.AddTimerState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

const val MAX_CHAR = 2

@HiltViewModel
class AddTimerViewModel @Inject constructor() : ViewModel() {

    var timerState by mutableStateOf(AddTimerState())
        private set

    fun onEvent(event: AddTimerEvent) {
        when (event) {
            is AddTimerEvent.TimeHoursChanged -> timerState =
                timerState.copy(hours = checkInput(timerState.hours, event.hours))
            is AddTimerEvent.TimeMinutesChanged -> timerState =
                timerState.copy(minutes = checkInput(timerState.minutes, event.minutes))
            is AddTimerEvent.TimeSecondsChanged -> timerState =
                timerState.copy(seconds = checkInput(timerState.seconds, event.seconds))
            is AddTimerEvent.IncrementMinutesChanged -> timerState =
                timerState.copy(incrementMinutes = checkInput(timerState.incrementMinutes, event.minutes))
            is AddTimerEvent.IncrementSecondsChanges -> timerState =
                timerState.copy(incrementSeconds = checkInput(timerState.incrementSeconds, event.seconds))

        }
    }

    private fun checkInput(current: String, input: String): String {
        return if (input.length <= MAX_CHAR && input.isNotBlank()) {
            try {
                if ((0..59).contains(input.toInt())) {
                    input
                } else {
                    Log.d("TAG", "AddTimerViewModel input out of bound")
                    current
                }
            } catch (e: Exception){
                return current
            }
        } else if (input.isEmpty()) {
            Log.d("TAG", "AddTimerViewModel too many chars")
            return ""
        } else return current
    }
}
