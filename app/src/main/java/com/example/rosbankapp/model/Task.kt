package com.example.rosbankapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task (
    val nameTask : String
    ) : Parcelable