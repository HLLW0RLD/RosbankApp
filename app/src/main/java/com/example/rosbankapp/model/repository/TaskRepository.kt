package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Task

class TaskRepository {

    var taskList: MutableList<Task> = mutableListOf(
        Task(0, "Задача1"),
        Task(1, "Задача2"),
        Task(2, "Задача3"),
        Task(3, "Задача4"),
        Task(4, "Задача5")
    )

    fun getTasks(): MutableList<Task> {
        return taskList
    }

    fun getTask(task: Task): Task {
        return taskList.get(task.id)
    }
}