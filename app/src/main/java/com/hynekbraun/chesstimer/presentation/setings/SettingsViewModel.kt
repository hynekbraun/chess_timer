package com.hynekbraun.chesstimer.presentation.setings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hynekbraun.chesstimer.domain.TimeModel
import com.hynekbraun.chesstimer.domain.TimeRepository
import com.hynekbraun.chesstimer.domain.toSettingsModel
import com.hynekbraun.chesstimer.presentation.setings.util.SettingsEvent
import com.hynekbraun.chesstimer.presentation.setings.util.SettingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: TimeRepository
) : ViewModel() {

    var viewState by mutableStateOf(SettingsState())
        private set

    fun onEvent(event: SettingsEvent){
        when (event){
            is SettingsEvent.OnDelete -> deleteTime(event.id)
            is SettingsEvent.OnTimeSelected -> {}
        }
    }

    init {
        observeTime()
    }

    private fun deleteTime(id: Int){
        viewModelScope.launch {
            repository.deleteTime(id)
        }
    }

    private fun observeTime() {
        viewModelScope.launch {
            repository.getTime().collect { times ->
                viewState = viewState.copy(list = times.map { it.toSettingsModel() })
            }
        }
    }
}