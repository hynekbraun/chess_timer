package com.hynekbraun.chesstimer

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

private const val COUNTDOWN_INTERVAL = 1000L
private const val START_TIME_LONG = 30000L

class TimerViewModel : ViewModel() {

    var currentTurn = CurrentTurn.NOBODY
        private set

    //Timer 1
    private val timeLeft1 = mutableStateOf(START_TIME_LONG)
    var time1AsString = mutableStateOf(longToString(timeLeft1.value))
        private set

    private var timer1: CountDownTimer = object : CountDownTimer(
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

    //Timer 2
    private val timeLeft2 = mutableStateOf(START_TIME_LONG)
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

    fun startTimer() {
        Log.d("TAG", "Time left onStart 1: ${timeLeft1.value} 2: ${timeLeft2.value}")
        when (currentTurn) {
            CurrentTurn.ONE -> {
                timer1.cancel()
                timer2 = object : CountDownTimer(timeLeft2.value, COUNTDOWN_INTERVAL) {
                    override fun onTick(p0: Long) {
                        Log.d("TAG", "Millis left 2 on Tick $p0")
                        time2AsString.value = longToString(p0)
                        timeLeft2.value = p0
                        Log.d("LOG", "Time left 2: ${timeLeft2.value}")
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
        time1AsString.value = longToString(START_TIME_LONG)
        timeLeft1.value = START_TIME_LONG
        timer2.cancel()
        time2AsString.value = longToString(START_TIME_LONG)
        timeLeft2.value = START_TIME_LONG
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
