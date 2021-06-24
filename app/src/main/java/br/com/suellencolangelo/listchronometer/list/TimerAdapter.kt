package br.com.suellencolangelo.listchronometer.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.suellencolangelo.listchronometer.databinding.TimerItemBinding

class TimerAdapter(private val items: List<TimerModel>, private val onTimerEnd: () -> Unit) :
    RecyclerView.Adapter<TimerViewHolder>() {

    private val countDownManager = CountDownManager()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimerViewHolder {
        val binding = TimerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TimerViewHolder(binding, onTimerEnd, countDownManager)
    }

    override fun onBindViewHolder(holder: TimerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onViewDetachedFromWindow(holder: TimerViewHolder) {
        super.onViewDetachedFromWindow(holder)
        countDownManager.unRegisterCountDown(holder)
    }

}

