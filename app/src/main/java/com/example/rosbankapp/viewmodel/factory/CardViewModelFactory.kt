package com.example.rosbankapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rosbankapp.model.repository.CardRepository
import com.example.rosbankapp.viewmodel.CardViewModel

class CardViewModelFactory(private val repository: CardRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CardViewModel() as T
    }
}