package com.hynekbraun.chesstimer.presentation.setings.util

import com.hynekbraun.chesstimer.domain.TimeModel

data class SettingsState(
    val list: List<TimeModel> = emptyList()
)
