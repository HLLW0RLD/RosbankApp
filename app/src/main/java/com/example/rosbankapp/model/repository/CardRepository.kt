package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Card

class CardRepository {

    var cardList: MutableList<Card> = mutableListOf(
        Card(0, "Иванов", "Задача1"),
        Card(1, "Петров", "Задача11")
    )

    fun getCard(id: Int) : Card{
        return cardList.get(id)
    }

    fun getCards(): MutableList<Card> {
        return cardList
    }
}