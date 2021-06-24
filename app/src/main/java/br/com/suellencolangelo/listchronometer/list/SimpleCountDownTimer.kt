package br.com.suellencolangelo.listchronometer.list

import android.os.CountDownTimer
import android.util.Log

private const val FIVE_MINUTES_IN_MILLS: Long = 300000
private const val ONE_MINUTE_IN_MILLS: Long = 60000
private const val ONE_SECOND_IN_MILLS: Long = 1000

class SimpleCountDownTimer(
    private val millisInFuture: Long = FIVE_MINUTES_IN_MILLS,
    private val countDownInterval: Long = ONE_SECOND_IN_MILLS,
) : CountDownTimer(millisInFuture, countDownInterval) {

    var listener: ((Long) -> Unit)? = null

    override fun onTick(millisUntilFinished: Long) {
        listener?.invoke(millisUntilFinished / 1000)
        Log.i("timer", "on timer tick")
    }

    override fun onFinish() {
        Log.i("timer", "on timer finished")
    }
}