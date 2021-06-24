package br.com.suellencolangelo.listchronometer.list

import android.os.CountDownTimer
import android.util.Log

private const val FIVE_MINUTES_IN_MILLS: Long = 60000
private const val ONE_MINUTE_IN_MILLS: Long = 60000
private const val ONE_SECOND_IN_MILLS: Long = 1000

class SimpleCountDownTimer(
    private val millisInFuture: Long = FIVE_MINUTES_IN_MILLS,
    private val countDownInterval: Long = ONE_SECOND_IN_MILLS,
) : CountDownTimer(millisInFuture, countDownInterval) {

    var listener: TimerListener? = null

    override fun onTick(millisUntilFinished: Long) {
        listener?.onTimeChange(millisUntilFinished / 1000)
        Log.i("timer", "on timer tick")
    }

    override fun onFinish() {
        listener?.onTimerFinished()
        Log.i("timer", "on timer finished")
    }

    interface TimerListener {
        fun onTimeChange(secondsUntilEnd: Long)
        fun onTimerFinished()
    }
}

