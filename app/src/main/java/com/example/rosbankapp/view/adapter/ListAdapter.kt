package com.example.rosbankapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Card
import com.example.rosbankapp.model.Task
import com.example.rosbankapp.view.EmployeeFragment

class ListAdapter : RecyclerView.Adapter<ListAdapter.MainViewHolder>() {

    private var cardList: MutableList<Card> = mutableListOf()

    fun setData(cards: MutableList<Card>) {
        this.cardList = cards

        notifyDataSetChanged()
    }

    fun add(addedCard: Card) {
        this.cardList.add(addedCard)
        if(this.cardList.size == 1){
            notifyDataSetChanged()
        }else{
            notifyItemInserted(0)
        }
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var name = itemView.findViewById<TextView>(R.id.card_employee)

        private var task = itemView.findViewById<TextView>(R.id.card_task)

        private var beginning = itemView.findViewById<TextView>(R.id.beginning)

        private var ending = itemView.findViewById<TextView>(R.id.ending)

        private var hours = itemView.findViewById<TextView>(R.id.hours)

        fun bind(card: Card) {

            name.text = card.employee

            task.text = card.task

            beginning.text = card.beginning

            ending.text = card.ending

            hours.text = card.hours

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}