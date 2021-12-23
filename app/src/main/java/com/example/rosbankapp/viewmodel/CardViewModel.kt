package com.example.rosbankapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rosbankapp.model.Callback
import com.example.rosbankapp.model.Card
import com.example.rosbankapp.model.repository.CardRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class CardViewModel : ViewModel() {

    private val cardsLiveData : MutableLiveData<MutableList<Card>> = MutableLiveData()

    fun getLiveData() = cardsLiveData

    fun addCard(card: Card){
        CardRepository.add(card)
    }

    fun getCards() {
        CardRepository.getCards(cardsLiveData)
    }
}