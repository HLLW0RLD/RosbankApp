package com.example.rosbankapp.model.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.rosbankapp.model.Callback
import com.example.rosbankapp.model.Card
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

object CardRepository {

    const val CARD = "card"
    const val ID = "id"
    const val EMPLOYEE = "employee"
    const val TASK = "task"
    const val BEGINNING = "beginning"
    const val ENDING = "ending"
    const val HOURS = "hours"

    private val database =
        FirebaseDatabase.getInstance("https://rosbankapp-72915-default-rtdb.europe-west1.firebasedatabase.app")
    private val cardReference = database.getReference("card")

    var cardList: MutableList<Card> = mutableListOf()

    fun add(card: Card) {
        val newId = UUID.randomUUID().toString()

        val newCard = Card(newId, card.employee, card.task, card.beginning, card.ending, card.hours)
        cardReference.child(UUID.randomUUID().toString()).setValue(newCard)
        cardList.add(0, newCard)
    }

    fun getCards(liveData: MutableLiveData<MutableList<Card>>) {
        cardReference
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val cards: MutableList<Card> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Card::class.java)} as MutableList<Card>
                    liveData.postValue(cards)
                    cardList = cards
                }
                override fun onCancelled(error: DatabaseError) {
                    // Nothing to do
                }
            })
    }
}