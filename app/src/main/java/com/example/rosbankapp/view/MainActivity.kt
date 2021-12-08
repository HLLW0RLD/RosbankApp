package com.example.rosbankapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Card
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = savedInstanceState?.getParcelable<Card>("CARD_BUNDLE")

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, EmployeeFragment.newInstance())
                .commitNow()
        }

        bottom_menu.also { bottomNavigation ->
            bottomNavigation.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.main_screen -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, EmployeeFragment.newInstance())
                            .commitNow()
                    }

                    R.id.task_list -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, ListFragment.newInstance())
                            .commitNow()
                    }
                }
                true
            }
        }
    }
}