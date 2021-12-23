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
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Card
import kotlinx.android.synthetic.main.fragment_employee.*
import java.util.*

class EmployeeFragment : Fragment() {

    companion object {

        const val CARD_BUNDLE = "CARD_BUNDLE"

        fun newInstance(bundle: Bundle): EmployeeFragment {
            val fragment = EmployeeFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance() = EmployeeFragment()
    }

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
                Toast.makeText(requireContext(), "Вы не заполнили все поля", Toast.LENGTH_SHORT)
                    .show()

            } else {

                val newId = UUID.randomUUID().toString()

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
}