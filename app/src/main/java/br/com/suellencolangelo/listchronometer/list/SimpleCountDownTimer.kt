package br.com.suellencolangelo.listchronometer.list

import android.os.CountDownTimer
import android.util.Log

private const val ONE_SECOND_IN_MILLS: Long = 1000

class SimpleCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
    CountDownTimer(millisInFuture, countDownInterval) {

    var listener: TimerListener? = null

    override fun onTick(millisUntilFinished: Long) {
        listener?.onTimeChange(millisUntilFinished / ONE_SECOND_IN_MILLS)
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

