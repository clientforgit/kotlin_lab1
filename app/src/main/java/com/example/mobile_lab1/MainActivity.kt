package com.example.mobile_lab1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobile_lab1.fragments.FuelOilFragment
import com.example.mobile_lab1.fragments.SolidFuelFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val solidFuelFragment = SolidFuelFragment()
        val fuelOilFragment = FuelOilFragment()
        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottom_nav_bar)

        setCurrentFragment(solidFuelFragment)

        bottomNavBar.setOnItemSelectedListener {
            Log.v("MainActivity", "onCreate")
            when (it.itemId) {
                R.id.solid_fuel -> {
                    setCurrentFragment(solidFuelFragment)
                    true
                }
                R.id.fuel_oil -> {
                    setCurrentFragment(fuelOilFragment)
                    true
                }
                else -> true
            }
        }
    }

    fun setCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fragment_container, fragment)
        commit()
    }
}
