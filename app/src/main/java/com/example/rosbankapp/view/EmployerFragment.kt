package com.example.rosbankapp.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Employer
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.model.repository.TaskRepository
import com.example.rosbankapp.view.search.NameSearchFragment

class EmployerFragment : Fragment() {

    companion object{

        const val NAME_BUNDLE = "NAME_BUNDLE"

        fun newInstance() = EmployerFragment()
    }

    var taskRepository = TaskRepository()

    var tasks : MutableList<Task> = taskRepository.getTasks()
    
    lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name = view.findViewById<TextView>(R.id.name)

        val result = arguments?.getParcelable<Employer>("NAME_BUNDLE")

        name.text = result?.name

        name.setOnClickListener {

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, NameSearchFragment.newInstance())
                .addToBackStack(NameSearchFragment.toString())
                .commit()
        }
    }
}