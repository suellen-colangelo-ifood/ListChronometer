package br.com.suellencolangelo.listchronometer.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.suellencolangelo.listchronometer.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        TimerAdapter(itemsList) { Log.i("timer", "timerOff") }
    }

    private val itemsList by lazy { getList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    private fun getList(): List<TimerModel> = mutableListOf<TimerModel>().also { list ->
        (1..100).forEach { _ ->
            val currentDate = Date()
            list.add(TimerModel(
                formattedTime = "",
                finalTimeMills = currentDate.time + 60000,
                timeNotifyIntervalMills = 1000,
            ))
        }
    }
}