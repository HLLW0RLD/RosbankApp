package com.example.rosbankapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rosbankapp.model.Card
import com.example.rosbankapp.model.repository.CardRepository

class CardViewModel(private val repository : CardRepository) : ViewModel() {

    private val cardsLiveData = MutableLiveData<MutableList<Card>>()

    private val cardLiveData = MutableLiveData<Card>()

    fun getLiveData() = cardLiveData

    fun getListLiveData() = cardsLiveData

    fun getCard(card: Card){
        val result = repository.getCard(card.id)

        cardLiveData.value = result
    }

    fun getCards(){
        val result = repository.getCards()

        cardsLiveData.value = result
    }
}