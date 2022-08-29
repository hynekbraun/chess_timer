package com.hynekbraun.chesstimer.presentation.setings.util

import com.hynekbraun.chesstimer.domain.TimeModel

sealed class SettingsEvent {
    data class OnDelete(val time: TimeModel) : SettingsEvent()
    data class OnTimeSelected(val id: Int) : SettingsEvent()
}
