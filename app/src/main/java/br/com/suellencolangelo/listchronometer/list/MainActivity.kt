package br.com.suellencolangelo.listchronometer.list

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.suellencolangelo.listchronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        TimerAdapter(itemsList) {
            Toast.makeText(this, "Cabou Cabou", Toast.LENGTH_SHORT).show()
            Log.i("timer", "timerOff")
        }
    }

    private val itemsList = listOf(
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