package com.example.mobile_lab1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.example.mobile_lab1.R
import com.example.mobile_lab1.databinding.FragmentSolidFuelBinding

//wh - working fuel hydrogen percentage
//wc - working fuel carbon percentage
//ws - working fuel sulphur percentage
//wn - working fuel nitrogen percentage
//wo - working fuel oxygen percentage
//ww - working fuel water percentage
//wa - working fuel ash percentage

fun calculateDryKoeff(ww: Double): Double {
    return 100 / (100 - ww)
}

fun calculateBurningKoeff(ww: Double, wa: Double): Double {
    return 100 / (100 - (ww + wa))
}

class SolidFuelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_solid_fuel, container, false)

        val binding = FragmentSolidFuelBinding.inflate(layoutInflater)

        val whInput = binding.whInput
        val wcInput = binding.wcInput
        val wsInput = binding.wsInput
        val wnInput = binding.wnInput
        val woInput = binding.woInput
        val wwInput = binding.wwInput
        val waInput = binding.waInput



        whInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val wh = whInput.text
                if (wh.isNullOrEmpty()) {
                    binding.whLayout.helperText = "Обов'язкове поле"
                } else if (wh.toString().toDouble() > 100) {
                    binding.whLayout.helperText = "Значення від 0 до 100"
                } else {
                    binding.whLayout.helperText = null
                }
            }
        }

        wcInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val wc = wcInput.text
                if (wc.isNullOrEmpty()) {
                    binding.wcLayout.helperText = "Обов'язкове поле"
                } else if (wc.toString().toDouble() > 100) {
                    binding.wcLayout.helperText = "Значення від 0 до 100"
                } else {
                    binding.wcLayout.helperText = null
                }
            }
        }

        wsInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val ws = wsInput.text
                if (ws.isNullOrEmpty()) {
                    binding.wsLayout.helperText = "Обов'язкове поле"
                } else if (ws.toString().toDouble() > 100) {
                    binding.wsLayout.helperText = "Значення від 0 до 100"
                } else {
                    binding.wsLayout.helperText = null
                }
            }
        }

        wnInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val wn = wnInput.text
                if (wn.isNullOrEmpty()) {
                    binding.wnLayout.helperText = "Обов'язкове поле"
                } else if (wn.toString().toDouble() > 100) {
                    binding.wnLayout.helperText = "Значення від 0 до 100"
                } else {
                    binding.wnLayout.helperText = null
                }
            }
        }

        woInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val wo = woInput.text
                if (wo.isNullOrEmpty()) {
                    binding.woLayout.helperText = "Обов'язкове поле"
                } else if (wo.toString().toDouble() > 100) {
                    binding.woLayout.helperText = "Значення від 0 до 100"
                } else {
                    binding.woLayout.helperText = null
                }
            }
        }

        wwInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val ww = wnInput.text
                if (ww.isNullOrEmpty()) {
                    binding.wwLayout.helperText = "Обов'язкове поле"
                } else if (ww.toString().toDouble() > 100) {
                    binding.wwLayout.helperText = "Значення від 0 до 100"
                } else {
                    binding.wwLayout.helperText = null
                }
            }
        }

        waInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val wa = waInput.text
                if (wa.isNullOrEmpty()) {
                    binding.waLayout.helperText = "Обов'язкове поле"
                } else if (wa.toString().toDouble() > 100) {
                    binding.waLayout.helperText = "Значення від 0 до 100"
                } else {
                    binding.waLayout.helperText = null
                }
            }
        }

        val calculateBtn = binding.buttonCalculate
        calculateBtn.setOnClickListener() {
            val whStr = whInput.text.toString()
            val wcStr = wcInput.text.toString()
            val wsStr = wsInput.text.toString()
            val wnStr = wnInput.text.toString()
            val woStr = woInput.text.toString()
            val wwStr = wwInput.text.toString()
            val waStr = waInput.text.toString()

            if (whStr.isEmpty() || wcStr.isEmpty() || wsStr.isEmpty() || wnStr.isEmpty() || woStr.isEmpty() || wwStr.isEmpty() || waStr.isEmpty()) {
                Toast.makeText(context, "Заповніть всі поля", Toast.LENGTH_SHORT).show()
            } else {
                val wh = whStr.toDouble()
                val wc = wcStr.toDouble()
                val ws = wsStr.toDouble()
                val wn = wnStr.toDouble()
                val wo = woStr.toDouble()
                val ww = wwStr.toDouble()
                val wa = waStr.toDouble()

                val kfd = calculateDryKoeff(ww)
                val kfb = calculateBurningKoeff(ww, wa)

                binding.dhLabel.text = "H: " + " " + String.format("%.2f", (kfd * wh))
                binding.dcLabel.text = "C: " + " " + String.format("%.2f", (kfd * wc))
                binding.dsLabel.text = "S: " + " " + String.format("%.2f", (kfd * ws))
                binding.dnLabel.text = "N: " + " " + String.format("%.2f", (kfd * wn))
                binding.doLabel.text = "O: " + " " + String.format("%.2f", (kfd * wo))
                binding.daLabel.text = "A: " + " " + String.format("%.2f", (kfd * wa))

                binding.bhLabel.text = "H: " + " " + String.format("%.2f", (kfb * wh))
                binding.bcLabel.text = "C: " + " " + String.format("%.2f", (kfb * wc))
                binding.bsLabel.text = "S: " + " " + String.format("%.2f", (kfb * ws))
                binding.bnLabel.text = "N: " + " " + String.format("%.2f", (kfb * wn))
                binding.boLabel.text = "O: " + " " + String.format("%.2f", (kfb * wo))

                val wq = 339 * wc + 1030 * wh - 108.8 * (wo - ws) - 25 * ww
                val dq = 100 * (wq + 0.025 * ww) / (100 - ww)
                val bq = 100 * (wq + 0.025 * ww) / (100 - (ww + wa))

                binding.wqLayout.text = "Робочого: " + " " + String.format("%.2f", wq)
                binding.dqLayout.text = "Сухого: " + " " + String.format("%.2f", dq)
                binding.bqLayout.text = "Горючого: " + " " + String.format("%.2f", bq)

            }

//            binding.result.text = result.toString()
        }

        return binding.root
    }
}