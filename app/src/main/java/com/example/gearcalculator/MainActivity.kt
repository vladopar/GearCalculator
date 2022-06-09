package com.example.gearcalculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gearcalculator.data.cassetteMap
import com.example.gearcalculator.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var front: Double? = null
        var rear: List<Double>? = null
        var ratios: MutableList<Double> = mutableListOf()

        binding.spinnerFront.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                front = binding.spinnerFront.selectedItem.toString().toDouble()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.spinnerRear.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                rear = cassetteMap[binding.spinnerRear.selectedItem.toString()]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.button.setOnClickListener {
            ratios.clear()
            for (i in rear?.indices!!) {
                val ratio = front!! / rear!![i]
                ratios!!.add(String.format("%.2f", ratio).toDouble())
            }
            binding.textView.text = ratios.toString()
        }


    }
}