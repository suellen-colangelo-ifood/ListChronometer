package br.com.suellencolangelo.listchronometer.list

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.suellencolangelo.listchronometer.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { TimerAdapter(itemsList) }

    private val itemsList = listOf(
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
        TimerModel("3:00"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

}