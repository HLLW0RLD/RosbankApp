package com.example.rosbankapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Employer(
    val id : Int,
    val name : String
) : Parcelable