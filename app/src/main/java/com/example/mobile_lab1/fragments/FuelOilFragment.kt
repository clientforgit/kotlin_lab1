package com.example.mobile_lab1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobile_lab1.R
import com.example.mobile_lab1.databinding.FragmentFuelOilBinding

fun calculateWorkingKoeff(ww: Double, wa: Double): Double {
    return (100 - (ww + wa)) / 100
}

class FuelOilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_fuel_oil, container, false)


        val binding = FragmentFuelOilBinding.inflate(layoutInflater)

        val whInput = binding.whInput
        val wcInput = binding.wcInput
        val wsInput = binding.wsInput
        val wvInput = binding.wvInput
        val woInput = binding.woInput
        val wwInput = binding.wwInput
        val waInput = binding.waInput
        val wqInput = binding.wqInput



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

        wvInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val wv = wvInput.text
                if (wv.isNullOrEmpty()) {
                    binding.wvLayout.helperText = "Обов'язкове поле"
                }else {
                    binding.wvLayout.helperText = null
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
                val ww = wwInput.text
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

        wqInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val wq = wqInput.text
                if (wq.isNullOrEmpty()) {
                    binding.wqLayout.helperText = "Обов'язкове поле"
                } else {
                    binding.wqLayout.helperText = null
                }
            }
        }

        val calculateBtn = binding.buttonCalculate
        calculateBtn.setOnClickListener() {
            val whStr = whInput.text.toString()
            val wcStr = wcInput.text.toString()
            val wsStr = wsInput.text.toString()
            val wvStr = wvInput.text.toString()
            val woStr = woInput.text.toString()
            val wwStr = wwInput.text.toString()
            val waStr = waInput.text.toString()
            val wqStr = wqInput.text.toString()

            if (whStr.isEmpty() || wcStr.isEmpty() || wsStr.isEmpty() || wvStr.isEmpty() || woStr.isEmpty() || wwStr.isEmpty() || waStr.isEmpty() || wqStr.isEmpty()) {
                Toast.makeText(context, "Заповніть всі поля", Toast.LENGTH_SHORT).show()
            } else {
                val wh = whStr.toDouble()
                val wc = wcStr.toDouble()
                val ws = wsStr.toDouble()
                val wv = wvStr.toDouble()
                val wo = woStr.toDouble()
                val ww = wwStr.toDouble()
                val wa = waStr.toDouble()
                val wq = wqStr.toDouble()

                val kfw = calculateWorkingKoeff(ww, wa)

                binding.whLabel.text = "H: " + " " + String.format("%.2f", (kfw * wh))
                binding.wcLabel.text = "C: " + " " + String.format("%.2f", (kfw * wc))
                binding.wsLabel.text = "S: " + " " + String.format("%.2f", (kfw * ws))
                binding.wvLabel.text = "v: " + " " + String.format("%.2f", ((100 - ww) * wv / 100))
                binding.woLabel.text = "O: " + " " + String.format("%.2f", ((100 - ww * 0.1 - wa * 0.1) * wo / 100))
                binding.waLabel.text = "A: " + " " + String.format("%.2f", ((100 - ww) * wa / 100))

                val bq = (wq * (100 - ww - wa) / 100 - 0.025 * ww) * 1000

                binding.wqLabel.text = "Горючого: " + " " + String.format("%.2f", bq)

            }

//            binding.result.text = result.toString()
        }


        return binding.root
    }
}