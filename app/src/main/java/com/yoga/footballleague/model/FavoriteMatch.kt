package com.yoga.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteMatch(
    val teamHomeName : String?,
    val teamAwayName : String?,
    val scoreHome : String?,
    val scoreAway : String?,
    val dateMatch : String?,
    val GkHome : String?,
    val GkAway : String?,
    val defHome : String?,
    val defAway : String?,
    val midHome : String?,
    val midAway : String?,
    val forHome : String?,
    val foraway : String?,
    val subHome : String?,
    val subAway : String?
):Parcelable