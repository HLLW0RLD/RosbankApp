package com.example.rosbankapp.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Employer
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.model.repository.TaskRepository
import com.example.rosbankapp.view.search.NameSearchFragment
import com.example.rosbankapp.view.search.TaskSearchFragment
import com.example.rosbankapp.viewmodel.EmployerViewModel
import kotlinx.android.synthetic.main.fragment_employer.*

class EmployerFragment : Fragment() {

    companion object{

        const val NAME_BUNDLE = "NAME_BUNDLE"

        const val TASK_BUNDLE = "TASK_BUNDLE"

        fun newInstance(bundle: Bundle) : EmployerFragment{
            val fragment = EmployerFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance() = EmployerFragment()
    }

    val viewModelEmployer : EmployerViewModel by lazy {
        ViewModelProvider(this).get(EmployerViewModel::class.java)
    }


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

        var task = view.findViewById<TextView>(R.id.task)

        arguments?.getParcelable<Employer>("NAME_BUNDLE")?.let { viewModelEmployer.getEmployee(it) }

        arguments?.getParcelable<Task>("TASK_BUNDLE")

        viewModelEmployer.getLiveData().observe(viewLifecycleOwner, {showNameInfo(it)})

        name.setOnClickListener {

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, NameSearchFragment.newInstance())
                .addToBackStack(NameSearchFragment.toString())
                .commit()
        }

        task.setOnClickListener {

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, TaskSearchFragment.newInstance())
                .addToBackStack(TaskSearchFragment.toString())
                .commit()
        }
    }

    fun showNameInfo(employer: Employer){

        name.text = employer.name
    }
}