package com.example.rosbankapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Employer
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.model.repository.TaskRepository
import com.example.rosbankapp.view.EmployerFragment.Companion.NAME_BUNDLE
import com.example.rosbankapp.view.search.NameSearchFragment

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