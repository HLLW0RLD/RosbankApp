package com.example.rosbankapp.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.model.repository.TaskRepository
import com.example.rosbankapp.view.EmployeeFragment
import com.example.rosbankapp.view.adapter.TaskAdapter

class TaskSearchFragment : Fragment() {

    companion object {
        fun newInstance() = TaskSearchFragment()
    }

    interface onTaskClick {
        fun onTaskClick(task: Task)
    }

    var taskRepository = TaskRepository()

    var tasks: MutableList<Task> = taskRepository.getTasks()

    val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.task_list)

        recyclerView.adapter = adapter

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter.setTaskClickListener(onTaskClickListener)

        val searchView = view.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_task)

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                if (p0 != null) {
                    filter(p0)
                }

                return true
            }
        })
    }

    fun filter(newText: String) {
        var filteredList: MutableList<Task> = mutableListOf()

        for (item in tasks) {
            if (item.nameTask.toLowerCase().contains(newText.toLowerCase()))
                filteredList.add(item)
        }
        adapter.filterList(filteredList)
    }

    private val onTaskClickListener = object : onTaskClick {
        override fun onTaskClick(task: Task) {
            val bundle = Bundle()
            bundle.putParcelable(EmployeeFragment.TASK_BUNDLE, task)
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, EmployeeFragment.newInstance(bundle))
                .addToBackStack(EmployeeFragment.toString())
                .commit()

        }
    }
}