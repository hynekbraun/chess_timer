package com.hynekbraun.chesstimer.presentation.setings.addtimer.util

sealed class AddTimerEvent {
    data class TimeHoursChanged(val hours: String) : AddTimerEvent()
    data class TimeMinutesChanged(val minutes: String) : AddTimerEvent()
    data class TimeSecondsChanged(val seconds: String) : AddTimerEvent()
    data class IncrementMinutesChanged(val minutes: String) : AddTimerEvent()
    data class IncrementSecondsChanges(val seconds: String) : AddTimerEvent()
    data class ChangeName(val name: String): AddTimerEvent()
    object SaveTime: AddTimerEvent()
}
