package com.hynekbraun.chesstimer

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hynekbraun.chesstimer.data.local.timedatastore.TimeDataStore
import com.hynekbraun.chesstimer.domain.TimeRepository
import com.hynekbraun.chesstimer.presentation.timer.util.InitialTimer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val COUNTDOWN_INTERVAL = 1000L

@HiltViewModel
class TimerViewModel @Inject constructor(
    private val repository: TimeRepository,
    private val dataStore: TimeDataStore
) : ViewModel() {

    var currentTurn = CurrentTurn.NOBODY

    private var currentTimer by mutableStateOf(InitialTimer.initialTimer)

    //Timer 1
    private val timeLeft1 = mutableStateOf(currentTimer.timeStart)
    var time1AsString = mutableStateOf(longToString(timeLeft1.value))
        private set

    private var timer1: CountDownTimer = object : CountDownTimer(
        timeLeft1.value, COUNTDOWN_INTERVAL
    ) {
        override fun onTick(p0: Long) {
            time1AsString.value = longToString(p0)
            timeLeft1.value = p0
        }

        override fun onFinish() {
            resetTimer()
        }
    }

    //Timer 2
    private val timeLeft2 = mutableStateOf(currentTimer.timeStart)
    var time2AsString = mutableStateOf(longToString(timeLeft2.value))
        private set

    private var timer2: CountDownTimer = object : CountDownTimer(
        timeLeft2.value, COUNTDOWN_INTERVAL
    ) {
        override fun onTick(p0: Long) {
            Log.d("TAG", "Millis left 2 on Tick $p0")
            time2AsString.value = longToString(p0)
            timeLeft2.value = p0
            Log.d("LOG", "Time left 2: ${timeLeft2.value}")
        }

        override fun onFinish() {
            //Add some toast to say player 1 ran out of time
            resetTimer()
        }
    }

    init {
        initializeTimer()
    }

    private fun initializeTimer() {
        viewModelScope.launch {
            try {
                dataStore.selectedTime.collect {
                    repository.getTimeById(it).collect { result ->
                        currentTimer = result
                        timeLeft1.value = currentTimer.timeStart
                        time1AsString.value = longToString(timeLeft1.value)
                        timeLeft2.value = currentTimer.timeStart
                        time2AsString.value = longToString(timeLeft2.value)
                    }
                }
            } catch (e: Exception) {
            }
        }
    }

    fun startTimer() {
        when (currentTurn) {
            CurrentTurn.ONE -> {
                timer1.cancel()
                timer2 = object : CountDownTimer(timeLeft2.value, COUNTDOWN_INTERVAL) {
                    override fun onTick(p0: Long) {
                        Log.d("TAG", "Millis left 2 on Tick $p0")
                        time2AsString.value = longToString(p0)
                        timeLeft2.value = p0
                    }

                    override fun onFinish() {
                        //Add some toast that player 2 ran out of time
                        resetTimer()
                    }

                }
                timer2.start()
                currentTurn = CurrentTurn.TWO
            }
            CurrentTurn.TWO -> {
                timer2.cancel()
                timer1 = object : CountDownTimer(
                    timeLeft1.value, COUNTDOWN_INTERVAL
                ) {
                    override fun onTick(p0: Long) {
                        time1AsString.value = longToString(p0)
                        timeLeft1.value = p0
                    }

                    override fun onFinish() {
                        resetTimer()
                    }
                }
                timer1.start()
                currentTurn = CurrentTurn.ONE
            }
            CurrentTurn.NOBODY -> {
                timer1 = object : CountDownTimer(
                    timeLeft1.value, COUNTDOWN_INTERVAL
                ) {
                    override fun onTick(p0: Long) {
                        Log.d("TAG", "Millis left 1 on Tick $p0")
                        time1AsString.value = longToString(p0)
                        timeLeft1.value = p0
                        Log.d("LOG", "Time left 1: ${timeLeft1.value}")
                    }

                    override fun onFinish() {
                        resetTimer()
                    }
                }
                timer1.start()
                currentTurn = CurrentTurn.ONE
            }
        }
    }

    fun resetTimer() {
        Log.d("TAG", "Reset Timer Triggered")
        currentTurn = CurrentTurn.NOBODY
        timer1.cancel()
        timeLeft1.value = currentTimer.timeStart
        time1AsString.value = longToString(timeLeft1.value)
        timer2.cancel()
        timeLeft2.value = currentTimer.timeStart
        time2AsString.value = longToString(timeLeft2.value)
    }

    private fun longToString(time: Long): String {
        val seconds = (time / 1000) % 60
        val minutes = (time / (1000 * 60) % 60)
        val hours = (time / (1000 * 60 * 60) % 24)
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}

enum class CurrentTurn {
    ONE, TWO, NOBODY
}
