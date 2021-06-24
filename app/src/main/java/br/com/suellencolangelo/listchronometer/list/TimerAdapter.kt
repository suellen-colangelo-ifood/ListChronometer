package br.com.suellencolangelo.listchronometer.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.suellencolangelo.listchronometer.databinding.TimerItemBinding

class TimerAdapter(private val items: List<TimerModel>, private val onTimerEnd: () -> Unit) :
    RecyclerView.Adapter<TimerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TimerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onTimerEnd)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(
        private val binding: TimerItemBinding,
        private val onTimerEnd: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var countDownTimer: SimpleCountDownTimer? = null
        private var timerListener: SimpleCountDownTimer.TimerListener? = null

        fun bind(timer: TimerModel) {
            binding.timer = timer
            countDownTimer?.cancel()

            countDownTimer = SimpleCountDownTimer().also {

                timerListener = object : SimpleCountDownTimer.TimerListener {
                    override fun onTimeChange(secondsUntilEnd: Long) {
                        binding.timerText.text = " $secondsUntilEnd seconds "
                        timer.time = " $secondsUntilEnd seconds "
                    }

                    override fun onTimerFinished() {
                        onTimerEnd()
                    }
                }

                it.listener = timerListener
                it.start()
            }
        }
    }
}