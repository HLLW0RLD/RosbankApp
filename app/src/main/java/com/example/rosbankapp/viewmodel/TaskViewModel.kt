package com.example.rosbankapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.model.repository.TaskRepository

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    private val taskLiveData = MutableLiveData<Task>()

    private val tasksLiveData = MutableLiveData<List<Task>>()

    fun getLiveData() = taskLiveData

    fun getListLiveData() = tasksLiveData

    fun getTask(task: Task) {
        val result = repository.getTask(task)

        taskLiveData.value = result
    }

    fun getTasks() {
        val result = repository.getTasks()

        tasksLiveData.value = result
    }
}