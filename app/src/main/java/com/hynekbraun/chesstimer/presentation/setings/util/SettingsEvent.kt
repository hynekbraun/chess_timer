package com.hynekbraun.chesstimer.presentation.setings.util

import com.hynekbraun.chesstimer.domain.TimeModel

sealed class SettingsEvent {
    data class OnDelete(val id: Int) : SettingsEvent()
    data class OnTimeSelected(val id: Int) : SettingsEvent()
    object UndoDelete : SettingsEvent()
}
