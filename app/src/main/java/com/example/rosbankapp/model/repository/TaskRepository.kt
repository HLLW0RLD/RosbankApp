package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Task

class TaskRepository {

    var taskList : MutableList<Task> = mutableListOf(
        Task(1, "Задача1"),
        Task(2, "Задача2"),
        Task(3, "Задача3"),
        Task(4, "Задача4"),
        Task(5, "Задача5")
    )

    fun getTasks(): MutableList<Task> {
        return taskList
    }

    fun getTask(task: Task) : Task{
        return taskList.get(task.id)
    }
}