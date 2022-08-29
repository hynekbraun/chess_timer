package com.hynekbraun.chesstimer.presentation.setings.addtimer

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hynekbraun.chesstimer.domain.TimeModel
import com.hynekbraun.chesstimer.domain.TimeRepository
import com.hynekbraun.chesstimer.presentation.setings.addtimer.util.AddTimerEvent
import com.hynekbraun.chesstimer.presentation.setings.addtimer.util.AddTimerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val MAX_CHAR = 2

@HiltViewModel
class AddTimerViewModel @Inject constructor(
    private val repository: TimeRepository
) : ViewModel() {

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
                timerState.copy(
                    incrementMinutes = checkInput(
                        timerState.incrementMinutes,
                        event.minutes
                    )
                )
            is AddTimerEvent.IncrementSecondsChanges -> timerState =
                timerState.copy(
                    incrementSeconds = checkInput(
                        timerState.incrementSeconds,
                        event.seconds
                    )
                )
            is AddTimerEvent.ChangeName -> timerState =
                timerState.copy(name = event.name)
            AddTimerEvent.SaveTime -> saveTime()
        }
    }

    private fun saveTime() {
        viewModelScope.launch {
            val name = timerState.name
            val timeStart = stringToLong(
                timerState.hours,
                timerState.minutes,
                timerState.seconds
            )
            val timeIncrement = stringToLong(
                minutes = timerState.incrementMinutes,
                seconds = timerState.incrementSeconds
            )
            repository.insertTime(
                TimeModel(
                    id = 0,
                    name = if (name.isBlank()) "Timer" else timerState.name,
                    timeStart = timeStart,
                    timeGain = timeIncrement
                )
            )
        }
    }

    private fun stringToLong(hours: String = "", minutes: String, seconds: String): Long {
        val h = if (hours.isBlank()) 0 else hours.toInt()
        val m = if (minutes.isBlank()) 0 else minutes.toInt()
        val s = if (seconds.isBlank()) 0 else seconds.toInt()

        val timeInMillis = (
                h * 3600 +
                        m * 60
                        + s
                ) * 1000
        return timeInMillis.toLong()
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
            } catch (e: Exception) {
                return current
            }
        } else if (input.isEmpty()) {
            Log.d("TAG", "AddTimerViewModel too many chars")
            return ""
        } else return current
    }
}
