package com.hynekbraun.chesstimer

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

private const val COUNTDOWN_INTERVAL = 1000L
private const val START_TIME_LONG = 300000L

class TimerViewModel : ViewModel() {

    var currentTurn = CurrentTurn.NOBODY
        private set

    //Timer 1
    private val timer1: CountDownTimer = object : CountDownTimer(
        START_TIME_LONG, COUNTDOWN_INTERVAL
    ) {
        override fun onTick(p0: Long) {
            time1AsString.value = longToString(p0)
        }

        override fun onFinish() {
            resetTimer()
        }
    }
    var time1AsString = mutableStateOf(longToString(START_TIME_LONG))
        private set

    //Timer 2
    private val timer2: CountDownTimer = object : CountDownTimer(
        START_TIME_LONG, COUNTDOWN_INTERVAL
    ) {
        override fun onTick(p0: Long) {
            time2AsString.value = longToString(p0)
        }

        override fun onFinish() {
            resetTimer()
        }
    }
    var time2AsString = mutableStateOf(longToString(START_TIME_LONG))
        private set


    fun startTimer() {
        when (currentTurn) {
            CurrentTurn.ONE -> {
                timer1.cancel()
                timer2.start()
                currentTurn = CurrentTurn.TWO
            }
            CurrentTurn.TWO -> {
                timer2.cancel()
                timer1.start()
                currentTurn = CurrentTurn.ONE
            }
            CurrentTurn.NOBODY -> {
                timer1.start()
                currentTurn = CurrentTurn.ONE
            }
        }
    }

    fun resetTimer() {
        currentTurn = CurrentTurn.NOBODY
        timer1.cancel()
        time1AsString.value = longToString(START_TIME_LONG)
        timer2.cancel()
        time2AsString.value = longToString(START_TIME_LONG)
    }

    private fun longToString(time: Long): String {

        val minutes = TimeUnit.MILLISECONDS.toMinutes(time)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(time) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}

enum class CurrentTurn {
    ONE, TWO, NOBODY
}
