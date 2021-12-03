package com.example.rosbankapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rosbankapp.model.repository.TaskRepository
import com.example.rosbankapp.viewmodel.TaskViewModel

class TaskViewModelFactory (private val repository: TaskRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(repository) as T
    }
}