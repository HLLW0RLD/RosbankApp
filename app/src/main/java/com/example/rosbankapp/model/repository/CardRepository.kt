package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Card

object CardRepository {

    var cardList: MutableList<Card> = mutableListOf()

    fun add(card : Card){
        cardList.add(0, card)
    }

    fun getCard(id: Int) : Card{
        return cardList.get(id)
    }

    fun getCards(): MutableList<Card> {
        return cardList
    }
}