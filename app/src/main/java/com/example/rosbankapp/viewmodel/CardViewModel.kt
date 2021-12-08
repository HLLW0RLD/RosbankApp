package com.example.rosbankapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rosbankapp.model.Card
import com.example.rosbankapp.model.repository.CardRepository

class CardViewModel(private val repository: CardRepository) : ViewModel() {

    private val cardsLiveData : MutableLiveData<MutableList<Card>> = MutableLiveData()

    fun getLiveData() = cardsLiveData

    fun addCard(card: Card){
        cardsLiveData.value?.add(card)
    }

    fun getCard(card: Card) {
        repository.getCard(card.id)

    }

    fun getCards() {
        val result = repository.getCards()

        cardsLiveData.value = result
    }
}