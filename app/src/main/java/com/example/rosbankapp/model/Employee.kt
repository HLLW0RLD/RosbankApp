package com.example.rosbankapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Employee(
    val id: Int,
    val name: String,
) : Parcelable