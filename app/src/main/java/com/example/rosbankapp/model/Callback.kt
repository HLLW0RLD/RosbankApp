package com.example.rosbankapp.model

interface Callback<T> {
    fun onSuccess(result: MutableList<Card>)
}