package com.example.rosbankapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rosbankapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, EmployerFragment.newInstance())
                .commitNow()
        }
    }
}