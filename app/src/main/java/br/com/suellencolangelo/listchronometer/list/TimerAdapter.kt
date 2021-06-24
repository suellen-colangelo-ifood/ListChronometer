package br.com.suellencolangelo.listchronometer.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.suellencolangelo.listchronometer.databinding.TimerItemBinding

class TimerAdapter(private val items: List<TimerModel>) :
    RecyclerView.Adapter<TimerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TimerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: TimerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val countDownTimer: SimpleCountDownTimer by lazy {
            SimpleCountDownTimer()
        }

        fun bind(timer: TimerModel) {
            binding.timer = timer
            countDownTimer.start()
            countDownTimer.listener = {
                timer.time = " $it segundos "
                binding.timerText.text = " $it segundos "
            }
        }
    }
}