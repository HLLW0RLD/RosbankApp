package com.example.rosbankapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.view.search.TaskSearchFragment

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.MainViewHolder>() {

    private var taskList: List<Task> = listOf()

    private var clickedTask: TaskSearchFragment.onTaskClick? = null

    fun setTaskClickListener(click: TaskSearchFragment.onTaskClick) {
        this.clickedTask = click
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var name = itemView.findViewById<TextView>(R.id.card_name)

        fun bind(task: Task) {

            name.text = task.nameTask

            itemView.setOnClickListener { clickedTask?.onTaskClick(task) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskAdapter.MainViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun filterList(filteredList: MutableList<Task>) {
        taskList = filteredList
        notifyDataSetChanged()
    }


}