package com.example.rosbankapp.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Employer
import com.example.rosbankapp.model.repository.EmployerRepository
import com.example.rosbankapp.view.EmployerFragment
import com.example.rosbankapp.view.EmployerFragment.Companion.NAME_BUNDLE
import com.example.rosbankapp.view.adapter.NameAdapter

class NameSearchFragment : Fragment() {

    companion object{
        fun newInstance() = NameSearchFragment()
    }

    interface onNameClick{
        fun onNameClick(employer: Employer)
    }

    var employerRepository = EmployerRepository()

    var employers : MutableList<Employer> = employerRepository.getEmployers()

    val adapter = NameAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.name_list)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter.setNameClickListener(onNameClickListener)

        val searchView = view.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_name)

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
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

    fun filter(newText : String){
        var filteredList : MutableList<Employer> = mutableListOf()

        for(item in employers){
            if(item.name.toLowerCase().contains(newText.toLowerCase()))
                filteredList.add(item)
        }
        adapter.filterList(filteredList)
    }

    private val onNameClickListener = object : onNameClick{
        override fun onNameClick(employer: Employer){
            val bundle = Bundle()
            bundle.putParcelable(NAME_BUNDLE, employer)
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, EmployerFragment.newInstance())
                .addToBackStack(EmployerFragment.toString())
                .commit()

        }
    }

}
