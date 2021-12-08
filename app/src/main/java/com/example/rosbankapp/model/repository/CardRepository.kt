package com.example.rosbankapp.model.repository

import com.example.rosbankapp.model.Card

class CardRepository {

    var cardList: MutableList<Card> = mutableListOf(
//        Card(0, "Иванов", "Задача1", "10", "17", "30"),
//        Card(1, "Петров", "Задача11", "13", "20", "47"),
//        Card(2, "Сидоров", "Задача25", "1", "1", "5"),
//        Card(3, "Степанов", "Задача8", "20", "30", "10")
    )

    fun getCard(id: Int) : Card{
        return cardList.get(id)
    }

    fun getCards(): MutableList<Card> {
        return cardList
    }
}