package br.com.suellencolangelo.listchronometer.list

import androidx.recyclerview.widget.RecyclerView
import br.com.suellencolangelo.listchronometer.databinding.TimerItemBinding

class TimerViewHolder(
    private val binding: TimerItemBinding,
    private val onTimerEnd: () -> Unit,
    private val countDownManager: CountDownManager,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(timer: TimerModel) {
        binding.timer = timer

        SimpleCountDownTimer(timer.timeIntervalMills, timer.timeNotifyIntervalMills).also {
            it.listener = object : SimpleCountDownTimer.TimerListener {
                override fun onTimeChange(secondsUntilEnd: Long) {
                    binding.timerText.text = " $secondsUntilEnd seconds "
                    timer.formattedTime = " $secondsUntilEnd seconds "
                }

                override fun onTimerFinished() {
                    binding.timerText.text = " Tempo acabou "
                    timer.formattedTime = " Tempo acabou "
                    onTimerEnd()
                }
            }
            countDownManager.unRegisterCountDown(this)
            countDownManager.registerCountDown(this, it)
        }
    }
}