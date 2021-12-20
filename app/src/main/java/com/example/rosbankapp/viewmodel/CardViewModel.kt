package com.example.rosbankapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rosbankapp.model.Card
import com.example.rosbankapp.model.repository.CardRepository

class CardViewModel : ViewModel() {

    private val cardsLiveData : MutableLiveData<MutableList<Card>> = MutableLiveData()

    fun getLiveData() = cardsLiveData

    fun addCard(card: Card){
        CardRepository.add(card)

        //cardsLiveData.value?.add(card)
    }

    fun getCards() {
        val result = CardRepository.getCards()

        cardsLiveData.value = result
    }
}