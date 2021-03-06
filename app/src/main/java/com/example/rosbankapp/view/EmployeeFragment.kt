package com.example.rosbankapp.view

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Card
import com.example.rosbankapp.model.Employee
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.model.repository.EmployeeRepository
import com.example.rosbankapp.model.repository.TaskRepository
import com.example.rosbankapp.view.adapter.ListAdapter
import com.example.rosbankapp.view.search.NameSearchFragment
import com.example.rosbankapp.view.search.TaskSearchFragment
import com.example.rosbankapp.viewmodel.EmployeeViewModel
import com.example.rosbankapp.viewmodel.TaskViewModel
import com.example.rosbankapp.viewmodel.factory.EmployeeViewModelFactory
import com.example.rosbankapp.viewmodel.factory.TaskViewModelFactory
import kotlinx.android.synthetic.main.fragment_employee.*
import java.util.*

class EmployeeFragment : Fragment() {

    companion object {

        const val NAME_BUNDLE = "NAME_BUNDLE"

        const val TASK_BUNDLE = "TASK_BUNDLE"

        const val CARD_BUNDLE = "CARD_BUNDLE"

        fun newInstance(bundle: Bundle): EmployeeFragment {
            val fragment = EmployeeFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance() = EmployeeFragment()
    }

    val viewModelEmployee: EmployeeViewModel by activityViewModels { EmployeeViewModelFactory(EmployeeRepository()) }

    val viewModelTask: TaskViewModel by activityViewModels { TaskViewModelFactory(TaskRepository()) }

    var cards: MutableList<Card> = mutableListOf()

    val c = Calendar.getInstance()

    val year = c.get(Calendar.YEAR)

    val month = c.get(Calendar.MONTH)

    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employee, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Employee>("NAME_BUNDLE")?.let { viewModelEmployee.getEmployee(it) }

        arguments?.getParcelable<Task>("TASK_BUNDLE")?.let { viewModelTask.getTask(it) }

        viewModelEmployee.getLiveData().observe(viewLifecycleOwner, { showNameInfo(it) })

        viewModelTask.getLiveData().observe(viewLifecycleOwner, { showTaskInfo(it) })

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

        beginning.setOnClickListener {
            val dpd = DatePickerDialog(
                requireContext(), DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    beginning.text = "" + day + "/" + month + "/" + year
                }, year, month, day
            )
            dpd.show()
        }

        ending.setOnClickListener {
            val dpd = DatePickerDialog(
                requireContext(), DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    ending.text = "" + day + "/" + month + "/" + year
                }, year, month, day
            )
            dpd.show()
        }

        add_card.setOnClickListener {

            if (name.text.toString().isEmpty() || task.text.toString().isEmpty()
                || beginning.text.toString().isEmpty()
                || ending.text.toString().isEmpty() || hours.text.toString().isEmpty()
            ) {
                Toast.makeText(requireContext(), "???? ???? ?????????????????? ?????? ????????", Toast.LENGTH_SHORT)
                    .show()

            } else {

                val newId = cards.size + 1

                val card = Card(
                    newId,
                    name.text.toString(),
                    task.text.toString(),
                    beginning.text.toString(),
                    ending.text.toString(),
                    hours.text.toString()
                )

                val bundle = Bundle()
                bundle.putParcelable(CARD_BUNDLE, card)
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, ListFragment.newInstance(bundle))
                    .addToBackStack(ListFragment.toString())
                    .commit()
            }
        }

    }


    fun showNameInfo(employer: Employee) {

        name.text = employer.name
    }

    fun showTaskInfo(nameTask: Task) {

        task.text = nameTask.nameTask
    }
}