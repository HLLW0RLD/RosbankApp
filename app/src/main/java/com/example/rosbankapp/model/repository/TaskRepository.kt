package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Task

class TaskRepository {

    var taskList : MutableList<Task> = mutableListOf(
        Task("Задача1"),
        Task("Задача2"),
        Task("Задача3"),
        Task("Задача4"),
        Task("Задача5")
    )

    fun getTasks(): MutableList<Task> {
        return taskList
    }

}