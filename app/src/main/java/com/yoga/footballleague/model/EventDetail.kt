package com.yoga.footballleague.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventDetail(
    @field:SerializedName("idEvent")
    val idEvent: String?,

    @field:SerializedName("strHomeTeam")
    val strHomeTeam: String?,

    @field:SerializedName("strAwayTeam")
    val strAwayTeam: String?,

    @field:SerializedName("dateEvent")
    val dateEvent: String?,

    @field:SerializedName("intHomeScore")
    val intHomeScore: String?,

    @field:SerializedName("intAwayScore")
    val intAwayScore: String?,

    @field:SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,

    @field:SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String?,

    @field:SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,

    @field:SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String?,

    @field:SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,

    @field:SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String?,

    @field:SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String?,

    @field:SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,

    @field:SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String?,

    @field:SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?,

    @field:SerializedName("strSport")
    val strSport: String?


) : Parcelable