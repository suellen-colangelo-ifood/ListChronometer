package br.com.suellencolangelo.listchronometer.list

class CountDownManager {
    private val countDownListeners: MutableMap<TimerViewHolder, SimpleCountDownTimer> =
        mutableMapOf()

    fun registerCountDown(viewHolder: TimerViewHolder, countDown: SimpleCountDownTimer) {
        countDown.start()
        countDownListeners[viewHolder] = countDown
    }

    fun unRegisterCountDown(viewHolder: TimerViewHolder) {
        countDownListeners[viewHolder]?.cancel()
        countDownListeners.remove(viewHolder)
    }
}