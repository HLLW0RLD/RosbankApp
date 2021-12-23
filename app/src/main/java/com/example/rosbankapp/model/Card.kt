package com.example.rosbankapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Constructor

@Parcelize
data class Card(
    val id: Int,
    val employee: String,
    val task: String,
    val beginning: String,
    val ending: String,
    val hours: String
) : Parcelable {
    constructor() : this(1, "", "", "", "", "")
}
