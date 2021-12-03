package com.example.rosbankapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rosbankapp.model.repository.EmployeeRepository
import com.example.rosbankapp.viewmodel.EmployeeViewModel

class EmployeeViewModelFactory (private val repository: EmployeeRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeViewModel(repository) as T
    }
}