package com.example.rosbankapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosbankapp.R
import com.example.rosbankapp.model.Card
import com.example.rosbankapp.model.repository.CardRepository
import com.example.rosbankapp.view.adapter.ListAdapter
import com.example.rosbankapp.viewmodel.CardViewModel
import com.example.rosbankapp.viewmodel.factory.CardViewModelFactory

class ListFragment : Fragment() {

    companion object {

        fun newInstance(bundle: Bundle): ListFragment {
            val fragment = ListFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance() = ListFragment()

    }

    val viewModel: CardViewModel by activityViewModels { CardViewModelFactory(CardRepository()) }

    val adapter = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.card_list)

        recyclerView.adapter = adapter

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        arguments?.getParcelable<Card>("CARD_BUNDLE")?.let { newCardAdder(it)}

        viewModel.getLiveData().observe(viewLifecycleOwner, { adapter.setData(it) })

        viewModel.getCards()

    }

    fun newCardAdder(card: Card){
        viewModel.addCard(card)

        adapter.add(card)

    }
}