package com.example.rosbankapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Employee
import com.example.rosbankapp.view.search.NameSearchFragment

class NameAdapter : RecyclerView.Adapter<NameAdapter.MainViewHolder>() {

    private var nameList: List<Employee> = listOf()

    private var clickedName: NameSearchFragment.onNameClick? = null

    fun setNameClickListener(click: NameSearchFragment.onNameClick) {
        this.clickedName = click
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var name = itemView.findViewById<TextView>(R.id.card_name)

        fun bind(employer: Employee) {

            name.text = employer.name

            itemView.setOnClickListener { clickedName?.onNameClick(employer) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(nameList[position])
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    fun filterList(filteredList: MutableList<Employee>) {
        nameList = filteredList
        notifyDataSetChanged()
    }

}