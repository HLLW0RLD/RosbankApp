package com.example.rosbankapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Constructor
import java.util.*

@Parcelize
data class Card(
    val id: String,
    val employee: String,
    val task: String,
    val beginning: String,
    val ending: String,
    val hours: String
) : Parcelable {
    constructor() : this("", "", "", "", "", "")
}
